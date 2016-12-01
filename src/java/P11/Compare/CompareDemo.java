package P11.Compare;

import java.util.*;

/**
 * Created by Mc on 2016/12/1.
 */
public class CompareDemo {
    public static void main(String[] args) {
        List<NovelNews> novelNewses = new ArrayList<>();
        novelNewses.add(new NovelNews(3));
        novelNewses.add(new NovelNews(2));
        novelNewses.add(new NovelNews(4));
        novelNewses.add(new NovelNews(5));
        novelNewses.add(new NovelNews(1));
        //用Collections.sort(List,Comparator)方法进行排序
        //这里的Comparator用了匿名内部类来实现Comparator接口，实际上也可以写一个类来实现Comparator接口
        //再用实现类的对象作为参数调用sort方法
        Collections.sort(novelNewses, new Comparator<NovelNews>() {
            int sortCount = 1;//排序计数

            @Override
            public int compare(NovelNews o1, NovelNews o2) {
                System.out.println("第" + sortCount + "次排序");
                System.out.println("o1=" + o1.getHeat());
                System.out.println("o2=" + o2.getHeat());
                System.out.println("compare result=" + ((Integer) o1.getHeat()).compareTo(o2.getHeat()));
                System.out.println("minus result=" + ((Integer) o1.getHeat()).compareTo(o2.getHeat()));
                System.out.println("=============");
                sortCount++;
                //由小至大排序，如果o1=o2则返回0，排序后o1在o2后返回正，o1在o2前返回负数
                //return ((Integer) o1.getHeat()).compareTo(o2.getHeat());
                return o1.getHeat() - o2.getHeat();
            }
        });

        System.out.println(novelNewses.toString());
    }
}
