package p5.AutoBoxingDemo;

/**
 * Created by Mc on 2016/12/4.
 */
class AutoBoxingDemo {
    public static void main(String[] args) {
        //自动装箱规范要求boolean、byte、char<=127、介于-128 ~ 127之间的short和int值被包装到固定对象
        //因此基本类型的对象在这些值范围内如果用“==”号进行比较，结果一定为true，但除此之外结果一定为false
        //因此如果要比较基本类型对象的值，最好用equals来比较
        Boolean bool1 = true;
        Boolean bool2 = true;
        System.out.println("bool1 == bool2? " + (bool1 == bool2));//true
        Integer integer1 = 1;
        Integer integer2 = 1;
        Integer integer3 = 1000;
        Integer integer4 = 1000;
        System.out.println("integer1 == integer2? " + (integer1 == integer2));//true
        System.out.println("integer3 == integer4? " + (integer3 == integer4));//false
        System.out.println("integer3 == integer4? " + (integer3.equals(integer4)));//true
    }
}
