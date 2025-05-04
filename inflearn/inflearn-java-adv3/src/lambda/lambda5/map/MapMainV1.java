package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;

public class MapMainV1 {
    public static void main(String[] args) {
        List<String> list = List.of("1", "12", "123", "1234");

        //문자열을 숫자로 변환
        List<Integer> numbers = mapToStringInteger(list);
        System.out.println("numbers = " + numbers);

        //문자열의 길이 반환
        List<Integer> lengths = mapToStringLength(list);
        System.out.println("lengths = " + lengths);
    }

    private static List<Integer> mapToStringInteger(List<String> list) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : list) {
            int result = Integer.parseInt(s);
            numbers.add(result);
        }
        return numbers;
    }

    private static List<Integer> mapToStringLength(List<String> list) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : list) {
            int result = s.length();
            numbers.add(result);
        }
        return numbers;
    }
}
