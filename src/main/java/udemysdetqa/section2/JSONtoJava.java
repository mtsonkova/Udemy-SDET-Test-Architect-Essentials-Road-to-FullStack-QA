package udemysdetqa.section2;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class JSONtoJava {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/business", "root", "rootpass");

        //object of statement class will help us to execute queries;

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Europe'");


        while(resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getInt(3));
            System.out.println(resultSet.getString(4));
        }

        connection.close();
    }
}
