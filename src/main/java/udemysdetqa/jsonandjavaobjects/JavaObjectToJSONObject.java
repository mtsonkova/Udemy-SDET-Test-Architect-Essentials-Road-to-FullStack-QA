package udemysdetqa.jsonandjavaobjects;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class JavaObjectToJSONObject {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "rootpass");

        //object of statement class will help us to execute queries;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select customerNumber, customerName, contactLastName, contactFirstName, city, country from customers limit 1;");
        CustomerDetails customerDetails;
        ArrayList<CustomerDetails> customerDetailsArr = new ArrayList<CustomerDetails>();
        String jsonPath;

        while(resultSet.next()) {
            customerDetails = new CustomerDetails();
            customerDetails.setCustomerNumber(resultSet.getInt(1)); //customerNumber
            customerDetails.setCustomerName(resultSet.getString(2)); //customerName
            customerDetails.setContactLastName(resultSet.getString(3)); //contactLastName
            customerDetails.setContactFirstName(resultSet.getString(4)); //contactFirstName
            customerDetails.setCity(resultSet.getString(5)); //city
            customerDetails.setCountry(resultSet.getString(6)); //country
            customerDetailsArr.add(customerDetails);
        }

        for(int i = 0; i < customerDetailsArr.size(); i++) {
           jsonPath = System.getProperty("user.dir") + "\\JsonFiles\\customerInfo" + i + ".json";

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(jsonPath), customerDetailsArr);
        }




        connection.close();
    }
}
