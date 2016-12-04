package p5.enumDemo;

/**
 * 枚举类Demo
 * Created by Mc on 2016/12/4.
 */
class EnumDemo {
    public static void main(String[] args) {
        //通过枚举类型获得枚举实例
        Size s = Size.EXTRA_LARGE;
        //Enum.toString的作用是返回枚举实例的名字
        System.out.println(s.toString());
        //通过Enum类的valueOf(class,String)方法获得枚举实例
        Size small = Enum.valueOf(Size.class, "SMALL");
        System.out.println("Size small.toString = " + small.toString());
        //获取枚举类内所有枚举实例的数组
        Size[] values = Size.values();
        for (Size value : values) {
            System.out.println(value.toString());
            //调用枚举类型实例的方法
            System.out.println("abbreviation = " + value.getAbbreviation());
        }
    }
}
