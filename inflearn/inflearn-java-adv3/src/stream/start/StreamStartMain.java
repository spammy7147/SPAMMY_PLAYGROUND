package stream.start;

import java.util.List;

public class StreamStartMain {
    public static void main(String[] args) {
        List<String> names = List.of("Apple", "Banana", "Berry", "Tomato");

        // "B"로 시작하는 이름만 필터 후 대문자로 바꿔서 리스트 수집
        List<String> result = names.stream()
                .filter(name -> name.startsWith("B"))
                .map(String::toUpperCase)
                .toList();

        System.out.println("=== 외부 반복 ===");
        for (String s : result) {
            System.out.println(s);
        }

        System.out.println("=== forEach, 내부 반복 ===");
        names.stream()
                .filter(name -> name.startsWith("B"))
                .map(String::toUpperCase)
                .forEach(System.out::println);

    }
}
