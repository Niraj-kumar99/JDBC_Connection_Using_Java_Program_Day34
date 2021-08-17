package javapractice;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollService {

    // this class used to read employee payroll from database using JDBC.
    public List<EmployeePayrollData> readData(){
        String sql = "SELECT * FROM employee_payroll";
        List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();
        try (Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                double salary = result.getDouble("salary");
                LocalDate startDate = result.getDate("start").toLocalDate();
                employeePayrollDataList.add(new EmployeePayrollData(id, name, salary, startDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeePayrollDataList;

    }

        /**
         * Purpose : Create connection with the database
         */
        private Connection getConnection() throws SQLException {
            String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
            String userName = "root";
            String password = "samarth1920";
            Connection connection;
            System.out.println("Connecting to database: "+jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection is successful! " +connection);
            return connection;
        }
}
