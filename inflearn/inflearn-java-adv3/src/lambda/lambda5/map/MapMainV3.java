package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MapMainV3 {
    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");

        //문자열을 숫자로 변환
        List<Integer> numbers = map(list, s -> Integer.valueOf(s));
        System.out.println("numbers = " + numbers);

        //문자열의 길이 반환
        List<Integer> lengths = map(list, s -> s.length());
        System.out.println("lengths = " + lengths);
    }

    private static <T,R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> resultList = new ArrayList<>();
        for (T s : list) {
            resultList.add(function.apply(s));
        }
        return resultList;
    }
}
