package p5.abstractClass;

/**
 * Employee类实现了Person类的所有抽象方法，所以Employee不再被定义为抽象类
 * Created by Mc on 2016/12/3.
 */
class Employee extends Person {
    private double salary;

    Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public void raiseSalary(double byPersent) {
        double raise = salary * byPersent / 100;
        salary = salary + raise;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String getDescription() {
        return "an employee with a salary of $" + salary;
    }
}
