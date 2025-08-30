package methodref;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class MethodRef4 {
    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("kim"),
                new Person("lee"),
                new Person("park")
        );

        List<String> result1 = mapPersonToString(personList, (Person person) -> person.introduce());
        List<String> result2 = mapPersonToString(personList, Person::introduce);
        System.out.println("result1 : " + result1);
        System.out.println("result2 : " + result2);

        List<String> upperResult1 = mapStringToString(result1, (String s) -> s.toUpperCase());
        List<String> upperResult2 = mapStringToString(result1, String::toUpperCase);
        System.out.println("upperResult1 = " + upperResult1);
        System.out.println("upperResult2 = " + upperResult2);

    }

    static List<String> mapPersonToString(List<Person> personList, Function<Person, String> function) {
        List<String> result = new ArrayList<>();
        for (Person person : personList) {
            String applied = function.apply(person);
            result.add(applied);
        }
        return result;
    }
    static List<String> mapStringToString(List<String> Strings, Function<String, String> function) {
        List<String> result = new ArrayList<>();
        for (String s : Strings) {
            String applied = function.apply(s);
            result.add(applied);
        }
        return result;
    }
}
