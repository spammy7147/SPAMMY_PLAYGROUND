package lambda.ex3;

import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceExample {

    public static int reduce(List<Integer> list, int initial, BinaryOperator<Integer> reducer) {
        int result = initial;

        for (Integer value : list) {
            result = reducer.apply(result, value);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        System.out.println("리스트: " + numbers);

        //1. 합 구하기(초기값 0, 덧셈 로직)
        int sum = reduce(numbers, 0, (a, b) -> a + b);

        System.out.println("합(누적 +): " + sum);

        int product = reduce(numbers, 1, (a, b) -> a * b);
        System.out.println("곱(누적 *): " + product);

    }
}
