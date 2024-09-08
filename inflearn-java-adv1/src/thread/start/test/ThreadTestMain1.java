package thread.start.test;

import static util.MyLogger.log;

public class ThreadTestMain1 {
    public static void main(String[] args) {
        CountThread thread = new CountThread();
        thread.start();
    }

    static class CountThread extends Thread {
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
