package p5.inheritance;

import java.util.Date;

/**
 * 开发者类，继承Employee类
 * Created by Mc on 2016/12/3.
 */
class Developer extends Employee {
    Developer(String name, double salary, Date hireDay) {
        super(name, salary, hireDay);
    }
}
