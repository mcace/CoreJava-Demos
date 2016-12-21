package p12.generic;

/**
 * 泛型类
 * 一般用T表示任意类型，K、V表示键与值，E表示集合的元素类型，实际上可以用任意字母表示泛型
 * Created by Mc on 2016/12/21.
 */
public class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    //不能实例化类型变量
    //因为类型擦除会把T都转为Object，因此这样是错误的写法
//    public Pair(){
//        first = new T();//Error
//        second = new T();
//    }
    //但可以利用Class.newInstance方法来构造泛型对象，但T.class依然会报错，必须用Class<T>作为参数进行构造
    public static <T> Pair<T> makePair(Class<T> cl){
        try {
            //cl.newInstance构造了一个泛型对象，但并不是T.class
            return new Pair<>(cl.newInstance(),cl.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public T getSecond() {
        return second;
    }

    public void setSecond(T second) {
        this.second = second;
    }
}
