package javapractice;

import java.time.LocalDate;
import java.util.List;

public class EmployeePayrollData {

    public int id;
    public String name;
    public double salary;
    public LocalDate start;

    public EmployeePayrollData(int id, String name, double salary, LocalDate start) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.start = start;
    }
}
