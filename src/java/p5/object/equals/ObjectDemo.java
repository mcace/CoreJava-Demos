package p5.object.equals;

import java.util.Date;
import java.util.Objects;

/**
 * Created by Mc on 2016/12/3.
 */
class ObjectDemo {
    private static final Date hireDay = new Date();//保证Employee对象hireDay参数一致

    public static void main(String[] args) {
        //Object类的equals方法比较两个对象是否是同一对象，如果没有重写该方法，则与==的作用相同
        Employee employee1 = new Employee("Jim", 8000, hireDay);
        Employee employee2 = new Employee("Jim", 8000, hireDay);
        System.out.println("Is employee1 equals employee2? " + employee1.equals(employee2));//false
        System.out.println("Is employee1 == employee2? " + (employee1 == employee2));//false
        //employee1 = employee2;
        //System.out.println(employee1.equals(employee2));//true
        //System.out.println(employee1 == employee2);//true

        //为了避免有对象为null的情况，我们可以调用Objects.equals(Object,Object)方法
        //在两个都为null时返回true，两个都非null时调用对象的equals方法，否则返回false
        System.out.println("Objects.equals(employee1, employee2) = " + Objects.equals(employee1,
                employee2));//true
        System.out.println("Objects.equals(null, employee2) = " + Objects.equals(null,
                employee2));//true

        Manager manager1 = new Manager("mc", 8000, hireDay);
        Manager manager2 = new Manager("Kim", 8000, hireDay);
        Manager manager3 = new Manager("mc", 8000, hireDay);
        //Manager类重写了equals方法，因此可以利用重写后的逻辑判断对象是否相等
        System.out.println("Is manager1 equals manager2? " + manager1.equals(manager2));
        System.out.println("Is manager1 equals manager3? " + manager1.equals(manager3));
    }
}
