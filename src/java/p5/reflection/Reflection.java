package p5.reflection;

import java.util.Date;

/**
 * 反射相关Demo
 * Created by Mc on 2016/12/7.
 */
public class Reflection {
    public static void main(String[] args) throws Exception {
        //Java Runtime System会给每个对象维护一个运行时的类型标识
        //这个信息跟踪着每个对象所属的类
        Employee e = new Employee("Mc", 9000, new Date());
        //保存这些信息的类是Class
        Class cl1 = e.getClass();
        System.out.println("cl1.getName = " + cl1.getName() + " " + e.getName());

        //还可以用静态方法获取Class对象
        Class cl2 = Class.forName("p5.reflection.Employee");
        //该方法会抛出检查异常，需要处理或抛出
        System.out.println("cl2.getName = " + cl2.getName());

        //第三种获取Class的方法是通过Java类.class获取
        Class cl3 = Employee.class;
        System.out.println("cl3.getName = " + cl3.getName());

        //数组类型的Class对象getName时会返回一个[L开头的字符串
        Class cl4 = Employee[].class;
        System.out.println("cl4.getName = " + cl4.getName());
        //int数组是[I
        Class cl5 = int[].class;
        System.out.println("cl5.getName = " + cl5.getName());
        //double数组是[D
        //可得基本类型的数组的ClassName都是基本类型名开头字母大写，而自定义类型数组的ClassName是以[L开头
        Class cl6 = double[].class;
        System.out.println("cl6.getName = " + cl6.getName());

        //虚拟机为每个类型管理一个Class对象，因此可以通过==判断Class对象是否相同
        System.out.println("cl1 == cl2 = " + (cl1 == cl2));

        //使用Class对象的newInstance方法可以创建一个类的实例
        //但如果需要使用带参数的构造方法，那么就需要用Constructor类的newInstance方法
        //比如Employee没有无参的构造方法，使用Class类的newInstance就会抛出异常InstantiationException
        //Object o = Class.forName("p5.reflection.Employee").newInstance();//java.lang.InstantiationException: p5.reflection.Employee
    }
}
