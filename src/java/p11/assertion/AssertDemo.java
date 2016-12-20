package p11.assertion;

/**
 * 断言Demo
 * Created by Mc on 2016/12/20.
 */
public class AssertDemo {
    public static void main(String[] args) {
        //断言在调试时会产生作用，而发布后会被自动移除
        //Java中断言有两种形式：assert 条件;  assert 条件:表达式;
        //运行时会对条件检测，返回false时会抛出AssertionException
        //当有表达式时，会把表达式传入AssertionError的构造器，并转换成消息字符串

        //下面的代码会返回一个AssertionError
        //assert 1 < 0;
        //但你直接执行是不会有效果的，因为java在默认情况下是关闭断言的
        //要想使用断言，要在运行时添加-ea或-enableassertions选项启用

        //下面试试带表达式的断言
        assert 1 < 0 : "Test 1 < 0 : " + (1 < 0);
    }
}
