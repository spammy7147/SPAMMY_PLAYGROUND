package lambda.lambda5.map;

import java.util.List;

public class MapMainV5 {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "orange");

        List<String> upperFruits = GenericMapper.map(fruits, s -> s.toUpperCase());
        System.out.println("upperFruits = " + upperFruits);

        List<Integer> lengthFruits = GenericMapper.map(fruits, s -> s.length());
        System.out.println("lengthFruits = " + lengthFruits);

        List<Integer> integers = List.of(1, 2, 3);
        List<String> startList = GenericMapper.map(integers, n -> "*".repeat(n));
        System.out.println("startList = " + startList);
    }

}
