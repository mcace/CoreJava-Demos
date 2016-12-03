package p5.object.equals;

import java.util.Date;
import java.util.Objects;

/**
 * 员工类
 * Created by Mc on 2016/11/29..
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

    @Override
    /*
    equals设计规范
    1.显式参数命名为otherObject，稍后用转换为命名other的另一个对象
    2.判断this == otherObject，判断他们是否引用的是同一对象
    3.判断otherObject引用是否为null
    4.当equals在每个子类都有不同的语义时，使用getClass判断this与otherObject是否是同一个类
      当equals在每个子类都有相同的语义时，使用instanceof判断
    5.将otherObject转换为相应的类类型变量
    6.最后比较域(实例变量)，基本类型域用==进行比较，对象域用equals进行比较
      假如在子类重新定义equals，则要在其中包含super.equals(other)
     */
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;//对象相同直接返回true

        if (otherObject == null) return false;//参数为null直接返回false

        //测试类是否相同
        // equals方法在子类能重写的情况下不建议使用instanceof操作，而是getClass()
        // 因为无法避免子类的问题，假如使用instanceof时父类对象equals子类对象为true
        // 根据equals对称性原则，此时也要求了子类对象equals父类对象为true
        // 那么为了保证调用子类的equals将父类对象作为参数时具有相同的结果
        // 子类的equals就必然无法再考虑子类独有的实例变量了
        // 但如果父类确定了equals方法用final修饰，则子类无法重写equals方法
        // 那么可以使用instanceof在不同子类间进行比较
        if (getClass() != otherObject.getClass()) return false;

        Employee other = (Employee) otherObject;

        //String和Date类已经重写equals方法，所以可以直接用
        //return name.equals(other.name) &&
        //        salary == other.salary &&
        //        hireDay.equals(other.hireDay);

        //String和Date类已经重写equals方法，所以可以直接用
        //return getName().equals(other.getName()) &&
        //        getSalary() == other.getSalary() &&
        //        getHireDay().equals(other.getHireDay());

        //为了防止name或hireDate为null的情况，需要使用Objects.equals方法
        //在两个都为null时返回true，两个都非null时调用对象的equals方法，否则返回false
        return Objects.equals(name, other.name) &&
                salary == other.salary &&
                Objects.equals(hireDay, other.hireDay);
    }
}
