package p5.object;

import java.util.Date;
import java.util.Objects;

/**
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
    public boolean equals(Object obj) {
        if (this == obj) return true;//对象相同直接返回true

        if (obj == null) return false;//参数为null直接返回false

        if (getClass() != obj.getClass()) return false;//测试类是否相同

        Manager manager = (Manager) obj;

        //String和Date类已经重写equals方法，所以可以直接用
        //return getName().equals(manager.getName()) &&
        //        getSalary() == manager.getSalary() &&
        //        getHireDay().equals(manager.getHireDay());

        //为了防止name或hireDate为null的情况，需要使用Objects.equals方法
        //在两个都为null时返回true，两个都非null时调用对象的equals方法，否则返回false
        return Objects.equals(getName(), manager.getName()) &&
                getSalary() == manager.getSalary() &&
                Objects.equals(getHireDay(), manager.getHireDay());
    }
}
