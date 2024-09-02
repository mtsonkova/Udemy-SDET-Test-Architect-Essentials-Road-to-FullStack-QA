package udemysdetqa.section2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.SqlStatement;

import java.io.File;
import java.io.IOException;
import java.sql.*;

public class JSONtoJava {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "rootpass");

        //object of statement class will help us to execute queries;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select customerNumber, customerName, contactLastName, contactFirstName, city, country from customers limit 5;");
        CustomerDetails customerDetails;
        int counter = 0;

        while(resultSet.next()) {
            customerDetails = new CustomerDetails();
            customerDetails.setCustomerNumber(resultSet.getInt(1)); //customerNumber
            customerDetails.setCustomerName(resultSet.getString(2)); //customerName
            customerDetails.setContactLastName(resultSet.getString(3)); //contactLastName
            customerDetails.setContactFirstName(resultSet.getString(4)); //contactFirstName
            customerDetails.setCity(resultSet.getString(5)); //city
            customerDetails.setCountry(resultSet.getString(6)); //country
            counter++;

            String jsonPath = System.getProperty("user.dir") + "\\JsonFiles\\customerInfo" + counter + ".json";

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(jsonPath), customerDetails);
        }


        connection.close();
    }
}
