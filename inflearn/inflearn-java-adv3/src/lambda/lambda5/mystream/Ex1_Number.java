package lambda.lambda5.mystream;

import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMapper;

import java.util.ArrayList;
import java.util.List;

public class Ex1_Number {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> directResult = direct(numbers);
        System.out.println("directResult = " + directResult);

        List<Integer> lambdaResult = lambda(numbers);
        System.out.println("lambdaResult = " + lambdaResult);

    }

    private static List<Integer> lambda(List<Integer> numbers) {
        List<Integer> filterList = GenericFilter.filter(numbers, n -> n % 2 == 0);
        List<Integer> mappedList = GenericMapper.map(filterList, n -> n * 2);

        return mappedList;
    }

    private static List<Integer> direct(List<Integer> numbers) {
        ArrayList<Integer> result  = new ArrayList<>();
        for (Integer num : numbers) {
            if (num % 2 == 0) {
                result.add(num * 2);
            }
        }
        return result;
    }

}
