package P5.Inheritance;

import java.util.Date;

/**
 * Created by Mc on 2016/11/29.
 */
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, Date hireDay) {
        super(name, salary, hireDay);
        bonus = 0;
    }

    @Override
    public double getSalary() {
        double salary = super.getSalary();
        return salary + bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
