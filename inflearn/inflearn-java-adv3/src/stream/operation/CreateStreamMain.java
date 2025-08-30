package stream.operation;

import java.util.List;
import java.util.stream.Stream;

public class CreateStreamMain {
    public static void main(String[] args) {
        System.out.println("1. 컬렉션으로부터 생성");
        List<String> list = List.of("a", "b", "c");
        Stream<String> stream1 = list.stream();
        stream1.forEach(System.out::println);

        System.out.println("2. 배열로부터 생성");
        String[] arr = {"a", "b", "c"};
        Stream<String> stream2 = Stream.of(arr);
        stream2.forEach(System.out::println);

        System.out.println("3. Stream.of() 사용");
        Stream<String> stream3 = Stream.of("a", "b", "c");
        stream3.forEach(System.out::println);

        System.out.println("4. 무한 스트림 생성 - iterate()");
        //iterate: 초기값과 다음 값을 만드는 함수를 지정
        Stream<Integer> stream4 = Stream.iterate(0, n -> n + 2);
        stream4.limit(10).forEach(System.out::println);

        System.out.println("5. 무한 스트림 생성 - generate()");
        //generate: supplier를 사용하여 무한하게 생성
        Stream<Double> stream5 = Stream.generate(Math::random);
        stream5.limit(10).forEach(System.out::println);

    }
}
