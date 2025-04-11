package lambda.lambda3;

import java.util.function.Function;

public class TargetType2 {
    public static void main(String[] args) {
        Function<String, String> upperCase = s -> s.toUpperCase();
        String hello = upperCase.apply("hello");
        System.out.println("hello = " + hello);

        Function<Integer, Integer> square = n -> n * n;
        System.out.println("square.apply(3) = " + square.apply(3));
    }
}
