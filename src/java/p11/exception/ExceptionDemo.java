package p11.exception;

import java.io.*;
import java.util.Scanner;

/**
 * 异常Demo
 * Created by Mc on 2016/12/19.
 */
public class ExceptionDemo {

    //包装异常举例
    public void wrapException(String filePath) throws Exception {
        if (null == filePath) {
            return;
        }
        File file = new File(filePath);
        String canonicalPath = null;
        if (file.exists()) {
            try {
                canonicalPath = file.getCanonicalPath();
            } catch (IOException e) {
                //把IOException包装到另一个异常里，同时保留原异常的堆栈信息
                //这里为了举例，仅仅使用了Exception，实际上要包装异常应该使用一个具体的子类
                //Exception se = new Exception("file io error");
                //Exception se = new Exception("file io error", e);
                //包装异常
                //se.initCause(e);
                //throw se;

                //这句可以替代上面的包装代码
                throw new Exception("file io error", e);
            }
        }
    }

    //带资源的try块示例
    public void tryWithResource(String filePath) {
        //带资源的try块在退出时(正常执行结束或抛出异常后)会自动调用Closeable接口的close方法
        //并且可以定义多个资源
        //try块内的异常会被正确的捕获并抛出，close方法抛出的异常则会由addSuppressed方法增加到原异常
        //可以使用getSuppressed方法获得被抑制的异常
        try (Scanner in = new Scanner(new FileInputStream(filePath));
             PrintWriter out = new PrintWriter(filePath)) {
            while (in.hasNext()) {
                System.out.println(in.next());
            }
        } catch (FileNotFoundException e) {
            //捕获new FileInputStream(filePath)可能发生的异常
            e.printStackTrace();
        }
    }
}
