package p11.log;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 日志Demo
 * Created by Mc on 2016/12/20.
 */
public class LogDemo {
    public static void main(String[] args) {
        //基本日志，虚拟的日志，约等于System.out
        Logger.getGlobal().setLevel(Level.ALL);
        Logger.getGlobal().info("Test global log");

    }
}
