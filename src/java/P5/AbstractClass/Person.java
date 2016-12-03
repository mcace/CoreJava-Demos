package P5.AbstractClass;

/**
 * Created by Mc on 2016/12/3.
 */
abstract class Person {
    private String name;//姓名
    private String description;//描述

    Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    //抽象的get方法，由子类实现
    public abstract String getDescription();
}
