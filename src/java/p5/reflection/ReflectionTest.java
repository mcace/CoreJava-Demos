package p5.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 反射测试，输出一个类的构造
 * Created by Mc on 2016/12/7.
 */
public class ReflectionTest {
    public static void printClass() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter class name(e.g. java.util.Date java.lang.Double):");
        String name = in.next();

        try {
            Class cl = Class.forName(name);//获取输入的类
            Class superCl = cl.getSuperclass();//获取输入的超类
            String modifiers = Modifier.toString(cl.getModifiers());
            //打印类名
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print("class " + name);
            if (null != superCl && Object.class != superCl)
                System.out.print(" extends " + superCl.getName());
            System.out.print("\n{\n");
            //打印构造方法
            printConstructors(cl);
            System.out.println();
            //打印成员变量
            printFields(cl);
            System.out.println();
            //打印方法
            printMethods(cl);
            System.out.println("}");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //打印类的构造方法
    public static void printConstructors(Class cl) {
        Constructor[] constructors = cl.getConstructors();
        //遍历构造方法
        for (Constructor constructor : constructors) {
            //构造方法名
            String name = constructor.getName();
            System.out.print("  ");
            //构造方法访问权限
            String modifiers = Modifier.toString(constructor.getModifiers());//Modifier类提供转换
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.print(name + " (");
            //构造方法参数类型数组
            Class[] paramTypes = constructor.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    //打印类的方法
    public static void printMethods(Class cl) {
        //getMethods会返回包括继承自父类的方法，不包括任何私有方法
        //getDeclaredMethods会返回类定义的全部方法，不包括父类方法，包括类的私有方法
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print("  ");
            //打印访问权限，返回类型，方法名及方法参数类型
            Class retType = method.getReturnType();//返回类型
            String name = method.getName();//方法名
            String modifiers = Modifier.toString(method.getModifiers());//访问权限
            if (modifiers.length() > 0) System.out.print(modifiers + " ");//打印访问权限
            System.out.print(retType.getName() + " " + name + "(");//打印返回类型和方法名
            Class[] paramTypes = method.getParameterTypes();//方法参数类型
            for (int i = 0; i < paramTypes.length; i++) {
                Class paramType = paramTypes[i];
                if (i > 0) System.out.print(", ");
                System.out.print(paramType.getName());
            }
            System.out.println(");");
        }
    }

    //打印类的成员变量(域)
    public static void printFields(Class cl) {
        Field[] fields = cl.getDeclaredFields();//获得类全部域，不包括父类
        for (Field field : fields) {
            System.out.print("  ");
            String name = field.getName();//域名
            Class type = field.getType();//域类型
            String modifiers = Modifier.toString(field.getModifiers());//访问权限
            if (modifiers.length() > 0) System.out.print(modifiers + " ");
            System.out.println(type.getName() + " " + name + ";");
        }
    }

}
