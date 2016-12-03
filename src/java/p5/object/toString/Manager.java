package p5.object.toString;

import java.util.Date;

/**
 * 经理类，继承Employee类
 * Created by Mc on 2016/11/29.
 */
class Manager extends Employee {
    private double bonus;

    Manager(String name, double salary, Date hireDay) {
        super(name, salary, hireDay);
        bonus = 0;
    }

    @Override
    public double getSalary() {
        double salary = super.getSalary();
        return salary + bonus;
    }

    void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public boolean equals(Object otherObject) {
        //子类中先调用父类的equals来比较，如果通过则校验子类中的实例变量
        if (!super.equals(otherObject)) return false;
        Manager other = (Manager) otherObject;
        return bonus == other.bonus;
    }

    @Override
    public int hashCode() {
        //return Objects.hash(name, salary, hireDay);
        return super.hashCode() + 17 * Double.valueOf(bonus).hashCode();
    }

    @Override
    public String toString() {
        //因为父类为了演示Object的toString，所以这里不使用super.toString()了
        // 实际上下面代码除了bouns部分外，都应该通过super.toString方法获得
        return getClass().getName() + "[name = " + this.getName() + ",salary = " + this.getSalary()
                + ",hireDay = " + this.getHireDay() + "]" + "[bonus = " + bonus + "]";
    }
}
