package P5.AbstractClass;

/**
 * Student实现了Person的所有抽象方法，所以Student不再被定义为抽象类
 * Created by Mc on 2016/12/3.
 */
public class Student extends Person {
    private String major;//主修科目

    Student(String name, String major) {
        super(name);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String getDescription() {
        return "a student majoring in " + major;
    }
}
