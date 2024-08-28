package collection.deque.test.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class PrinterQueueTest {
    public static void main(String[] args) {
        Deque<String> printDeque = new ArrayDeque<>();

        printDeque.offer("doc1");
        printDeque.offer("doc2");
        printDeque.offer("doc3");

        System.out.println("출력: " + printDeque.poll());
        System.out.println("출력: " + printDeque.poll());
        System.out.println("출력: " + printDeque.poll());
    }
}
