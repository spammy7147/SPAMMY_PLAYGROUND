package thread.start.test;

import static util.MyLogger.log;

public class ThreadTestMain4 {
    public static void main(String[] args) {

        Thread A = new Thread(new PrintWork("A", 1000), "Thread-A");
        Thread B = new Thread(new PrintWork("B", 500), "Thead-B");
        A.start();
        B.start();
    }

    static class PrintWork implements Runnable {
        private String content;
        private int sleepMs;

        public PrintWork(String content, int sleepMs) {
            this.content = content;
            this.sleepMs = sleepMs;
        }

        @Override
        public void run() {
            while (true) {
                log(content);
                try {
                    Thread.sleep(sleepMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
