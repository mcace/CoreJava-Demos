package p5.enumDemo;

/**
 * Size枚举类
 * 每个枚举类都隐含继承自Enum类,因此枚举类不能继承其他类，但枚举类能实现接口
 * 每个枚举值都是一个枚举实例，而且不能再被实例化
 * 类似每个枚举实例都是由public static final修饰的常量的语句实例化出来的
 * 因此每个枚举实例都是单例的，枚举也可以拿来写单例对象
 * Created by Mc on 2016/12/4.
 */
enum Size {
    SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");

    //在定义完枚举值后，还可以自行添加构造器、方法和域
    private String abbreviation;

    private Size(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }
}
