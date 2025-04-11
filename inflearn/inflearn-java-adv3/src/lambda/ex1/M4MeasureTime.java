package lambda.ex1;

import lambda.Procedure;

import java.util.Arrays;

public class M4MeasureTime {

    public static void main(String[] args) {
        measure(() -> {
            int N = 100;
            long sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += i;
            }
            System.out.println("[1부터 "+ N + "까지 합] 결과: " + sum);
        });

        measure(() -> {
            int[] arr = { 4, 3, 2, 1 };
            System.out.println("원본 배열: " + Arrays.toString(arr));
            Arrays.sort(arr);
            System.out.println("배열 정렬: " + Arrays.toString(arr));
        });
    }

    static void measure(Procedure procedure) {
        long start = System.nanoTime();
        procedure.run();
        long end = System.nanoTime();
        System.out.println("실행 시간: " + (end - start) + "ns");
    }
}
