package p5.object.toString;

import java.util.Arrays;
import java.util.Date;

/**
 * toString方法Demo
 * Created by Mc on 2016/12/3.
 */
class ToStringDemo {
    public static void main(String[] args) {
        //Object类定义了toString方法，用来打印输出对象所属类名以及散列码(hashCode)
        ToStringDemo demo = new ToStringDemo();
        //println方法会调用对象的toString方法
        //本类并没有重写toString方法，因此调用的是Object类的toString方法
        //并且本类也没有重写hashCode方法，因此调用的也是Object类的hashCode方法
        System.out.println(demo);//result like "p5.object.toString.ToStringDemo@9ffdf86"

        //Employee重写了hashCode方法，因此返回的是类名@0(为验证，hashCode特别地设为0)
        Employee employee = new Employee("mike", 900, new Date());
        System.out.println(employee);

        //Manager类重写了所有方法
        Manager manager = new Manager("mc", 9000, new Date());
        manager.setBonus(100);
        System.out.println("manager.toString = " + manager);
        System.out.println("manager.hashCode = " + manager.hashCode());

        //数组的toString统一调用Object的toString，无法重写该方法，但可以调用Arrays.toString来返回
        Manager[] managers = new Manager[3];
        managers[0] = new Manager("mc", 9000, new Date());
        managers[1] = new Manager("jim", 9000, new Date());
        managers[2] = new Manager("tom", 9000, new Date());
        System.out.println("managers.toString = " + managers);
        System.out.println("Arrays.toString(managers) = " + Arrays.toString(managers));
    }
}
