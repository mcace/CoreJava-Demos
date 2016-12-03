package p5.inheritancee;

import java.util.Date;

/**
 * Created by Mc on 2016/11/29.
 */
class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    Employee(String name, double salary, Date hireDay) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public void raiseSalary(double byPersent) {
        double raise = salary * byPersent / 100;
        salary = salary + raise;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void setHireDay(Date hireDay) {
        this.hireDay = hireDay;
    }

}
