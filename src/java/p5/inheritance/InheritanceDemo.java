package p5.inheritance;

import java.util.Date;

/**
 * 继承Demo
 * Created by Mc on 2016/11/29..
 */
class InheritanceDemo {
    public static void main(String[] args) {
        Manager manager = new Manager("mc", 9000, new Date());
        manager.setBonus(900);
        Employee employee = manager;//Manager是Employee的子类
        //employee.setBonus(900);//无法调用
        /*Manager类重写了Employee的getSalary方法，虽然这时不能调用Manager类，但调用被重写的方法时
          被调用的是子类重写后的方法*/
        System.out.println(employee.getSalary());

        //强制类型转换
        //无法将父类强制转换为子类，可以将子类强制转换为父类
        //强制类型转换会出现ClassCastException
        Employee[] employee1 = new Employee[]{new Employee("jim", 900, new Date())};
        //Manager manager1 = (Manager)employee1[0];//ClassCastException
        //employee1[0] = new Manager("mc", 8000, new Date());//OK
        //使用instanceof在类型转换前检查对象的类
        if (employee1[0] instanceof Manager) {
            Manager manager2 = (Manager) employee1[0];
        }
        System.out.println(employee1[0].getSalary());
        //强制类型转换只能发生在继承层次内，下面的代码无法通过编译
        //Date date = (Date)employee1[0];
        System.out.println("hello");
    }
}
