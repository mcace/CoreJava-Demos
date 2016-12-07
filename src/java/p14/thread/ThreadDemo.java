package p14.thread;

/**
 * Created by Mc on 2016/12/7.
 */
public class ThreadDemo {
    public static void main(String[] args) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        System.out.print(i + " ");
                    }
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        System.out.print(i + " ");
                    }
                }
            }).start();
        }
}
