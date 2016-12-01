package P5.Inheritance;

import java.util.Date;

/**
 * Created by Mc on 2016/11/29.
 */
public class InheritanceDemo {
    public static void main(String[] args) {
        Manager manager = new Manager("mc",9000,new Date());
        manager.setBonus(900);
        Employee employee = manager;//Manager是Employee的子类
        //employee.setBonus(900);//无法调用
        /*Manager类覆写了Employee的getSalary方法，虽然这时不能调用Manager类，但调用被覆写的方法时
          被调用的是子类覆写后的方法*/
        System.out.println(employee.getSalary());
    }
}
