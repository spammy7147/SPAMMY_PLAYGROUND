package thread.start.test;

import static util.MyLogger.log;

public class ThreadTestMain2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new CountRunnable(), "counter");
        thread.start();
    }

    static class CountRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                log("value: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
