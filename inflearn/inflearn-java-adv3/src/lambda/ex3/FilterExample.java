package lambda.ex3;

import lambda.ex2.MyPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FilterExample {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(-3, -2, -1, 1, 2, 3, 5);
        System.out.println("원본 리스트 = " + numbers);

        List<Integer> evenList = filter(numbers, value -> (value % 2) == 0);
        System.out.println("짝수만 = " + evenList);

        List<Integer> negativeList = filter(numbers, value -> value < 0);
        System.out.println("음수만 = " + negativeList);
    }

    static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (int value : list) {
            if(predicate.test(value)) {
                result.add(value);
            }
        }
        return result;
    }
}
