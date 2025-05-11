package lambda.lambda5.mystream;

import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMapper;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class Ex2_Student {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("apple", 100),
                new Student("Banana", 80),
                new Student("Berry", 50),
                new Student("Tomato", 40)
        );

        List<String> directResult = direct(students);
        System.out.println("directResult = " + directResult);

        List<String> lambdaResult = lambda(students);
        System.out.println("lambdaResult = " + lambdaResult);

    }

    private static List<String> lambda(List<Student> students) {
        List<Student> filteredList = GenericFilter.filter(students, n -> n.getScore() >= 80);
        List<String> mappedList = GenericMapper.map(filteredList, n -> n.getName());

        return mappedList;
    }

    private static List<String> direct(List<Student> students) {
        List<String> names = new ArrayList<>();
        for (Student student : students) {
            if(student.getScore() >= 80) {
                names.add(student.getName());
            }
        }
        return names;
    }

}
