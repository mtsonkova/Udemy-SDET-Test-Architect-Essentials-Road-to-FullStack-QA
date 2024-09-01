package udemysdetqa.section2;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JSONtoJava {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = null;
        DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "rootpass");
    }
}
