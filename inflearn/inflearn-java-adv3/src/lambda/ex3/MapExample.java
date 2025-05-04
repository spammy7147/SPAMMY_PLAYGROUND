package lambda.ex3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MapExample {

    public static void main(String[] args) {
        List<String> origin = List.of("hello", "java", "lambda");
        System.out.println("원본 = " + origin);

        List<String> capitalize = map(origin, value -> value.toUpperCase());
        System.out.println("대문자 변환 결과: " + capitalize);

        List<String> decoration = map(origin, value -> "***" + value + "***");
        System.out.println("특수문자 데코 결과:  " + decoration);
    }

    static List<String> map(List<String> list, UnaryOperator<String> function) {
        List<String> result = new ArrayList<>();
        for (String s : list) {
            result.add(function.apply(s));
        }
        return result;
    }
}
