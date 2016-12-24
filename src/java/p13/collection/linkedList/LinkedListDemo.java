package p13.collection.linkedList;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * 链表Demo
 * Created by Mc on 2016/12/24.
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        List<String> staff = new LinkedList<>();
        staff.add("Amy");
        staff.add("Bob");
        staff.add("Carl");
        System.out.println("staff.get(0) = " + staff.get(0));
        //通过LinkedList的listIterator方法返回一个特有的listIterator
        ListIterator<String> iter = staff.listIterator();
        //此时迭代器位置在第1个元素前，所以添加的元素在队列头部
        iter.add("James");
        System.out.println("after ListIterator.add(\"James\"):");
        System.out.println("staff.get(0) = " + staff.get(0));
        System.out.println("staff.get(1) = " + staff.get(1));
        //但调用迭代器add方法后，此时迭代器位置在第1个元素后，所以添加的元素将位于第2个元素
        iter.add("Tom");
        //此时迭代器位置：J T|A B C
        //因此调用iter.next时，越过的元素是第三个元素，此时迭代器位置：J T A|B C
        //也就是说迭代器add方法是在迭代器所在位置前增加元素
        System.out.println("after ListIterator.add(\"Tom\"):");
        System.out.println("iter.next() = " + iter.next());
        System.out.println("staff.get(0) = " + staff.get(0));
        System.out.println("staff.get(1) = " + staff.get(1));
        System.out.println("staff.get(2) = " + staff.get(2));
        System.out.println();

        //迭代器的remove方法与add不同，add与迭代器位置有关，remove则只与刚刚越过的元素有关
        //接着刚刚的例子，此时迭代器刚刚越过Amy元素
        System.out.println("iter.previous() = " + iter.previous());//迭代器刚刚越过的元素是Amy
        System.out.println("staff.get(2) = " + staff.get(2));//Amy
        System.out.println("staff.size() = " + staff.size());
        iter.next();//迭代器重新置于Amy后
        //此时调用iter.remove，删除的就是Amy，但再次调用则会出现异常IllegalStateException
        iter.remove();
        System.out.println("after ListIterator.remove():");
        //System.out.println("after ListIterator.remove() again without ListIterator.next():");
        //iter.remove();//IllegalStateException
        //同时可知，此时迭代器位置没有变化，只是元素有变化(被移出)，此时迭代器位置：J T|B C
        System.out.println("iter.previous() = " + iter.previous());//Amy被移出，所以结果是Tom
        System.out.println("staff.get(2) = " + staff.get(2));//Bob
        System.out.println("staff.size() = " + staff.size());
        System.out.println();

        //迭代器添加尾部元素
        while (iter.hasNext()) iter.next();//获取最后一个元素
        System.out.println("last element:" + iter.previous());//Carl
        System.out.println("staff.size() = " + staff.size());
        iter.next();//迭代器置于尾部
        iter.add("Amy");//此时Amy被加入迭代器位置前，迭代器仍然在尾部，此时迭代器位置：J T B C A|
        //System.out.println("last element:" + iter.next());//NoSuchElementException
        System.out.println("after ListIterator.add(\"Amy\"):");
        System.out.println("last element:" + iter.previous());//尾部变为Amy
        System.out.println("staff.size() = " + staff.size());
        //此时仍然可以调用iter.add添加到尾部
        System.out.println();

        //Iterator.set方法与remove方法类似，set方法是修改刚刚越过的元素
        //接上例，刚刚被越过的元素是Amy
        System.out.println("staff.get(4) = " + staff.get(4));//Amy
        iter.set("John");
        System.out.println("after ListIterator.set(\"John\"):");
        System.out.println("staff.size() = " + staff.size());
        System.out.println("staff.get(4) = " + staff.get(4));//John
        //可知此时再调用set方法，修改的还是相同的元素
        iter.set("Hunter");
        System.out.println("after ListIterator.set(\"Hunter\"):");
        System.out.println("staff.size() = " + staff.size());
        System.out.println("staff.get(4) = " + staff.get(4));//Hunter

        //补充说明：ListIterator在检测到列表的结构被其他ListIterator修改(add,remove)时
        //再调用next,previous方法会抛出IllegalStateException
        //但如果是列表的数据被修改(set)，那么就不会有任何异常，注意一个是列表结构，一个是列表数据

        //最后，LinkedList的ListIterator和一般List的Iterator的区别：
        //一般的Iterator只有next,hasNext,remove
        //ListIterator则添加了add,set,previous,hasPrevious方法
    }
}
