package javapractice;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DBDemo {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_services?useSSL = false";
        String userName = "root";
        String password = "niraj";
        Connection connection;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded ..");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the classpath", e);
        }
        listDrivers();
        try
        {
            System.out.println("Connecting to database : "+jdbcURL);
            connection = DriverManager.getConnection(jdbcURL , userName , password);
            System.out.println("Connection is Successful ... " +connection);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void listDrivers()
    {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements())
        {
            Driver driverClass = (Driver)driverList.nextElement();
            System.out.println("  "+driverClass.getClass().getName());

            /*
             Upto this the connection with
             payroll_services DataBase is done ..
             */
        }
    }
}
