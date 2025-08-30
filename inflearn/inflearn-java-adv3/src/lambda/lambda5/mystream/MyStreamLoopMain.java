package lambda.lambda5.mystream;

import java.util.List;

public class MyStreamLoopMain {
    public static void main(String[] args) {

        List<Student> students = List.of(
                new Student("apple", 100),
                new Student("banana", 80),
                new Student("berry", 50),
                new Student("tomato", 40)
        );

        List<String> result = MyStreamV3.of(students)
                .filter(s -> s.getScore() >= 80)
                .map(s -> s.getName())
                .toList();

        for (String s : result) {
            System.out.println("name = " + s);
        }

        MyStreamV3.of(students)
            .filter(s -> s.getScore() >= 80)
            .map(s -> s.getName())
            .forEach(name -> System.out.println("name = " + name));

    }
}
