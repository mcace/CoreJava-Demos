package p5.object.hashCode;

import java.util.Date;
import java.util.Objects;

/**
 * HashCode(散列码)Demo
 * Created by Mc on 2016/12/3.
 */
class HashcodeDemo {
    private String name;
    private double salary;
    private Date hireDay;

    HashcodeDemo(String name, double salary, Date hireDay) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public static void main(String[] args) {
        //字符串的hashCode是由字符串内容决定的，String类重写了hashCode方法
        String a = "as";
        System.out.println("a.hashCode = " + a.hashCode());
        //Object类的hashCode是对象的存储地址，也就是所有对象都有个默认的hashCode
        // StringBuilder并没有重写hashCode，因此它的hashCode就是对象的存储地址
        StringBuilder sb = new StringBuilder(a);
        System.out.println("sb.hashCode = " + sb.hashCode());
        //因为字符串的hashCode是重写过，由字符串内容决定，因此当内容相同时
        // 即使是新的字符串对象的hashCode也等于旧的字符串对象
        String b = new String("as");
        System.out.println("b.hashCode = " + b.hashCode());

        //在1.7中可以调用null安全的Objects.hashCode，参数为null时返回0
        HashcodeDemo demo = new HashcodeDemo("mc", 8000, new Date());
        System.out.println("Null's hashCode = " + Objects.hash(null));
        System.out.println("HashcodeDemo's hashCode = " + Objects.hash(demo.name, demo.salary, demo
                .hireDay));
    }
}