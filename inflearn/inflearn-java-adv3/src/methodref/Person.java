package methodref;

public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static String greeting() {
        return "hello";
    }

    public static String greetingWithName(String name) {
        return "hello " + name;
    }
    public String introduce() {
        return "I am " + name;
    }
    public String introduceWithNumber(int number) {
        return "I am " + name + ", my number is " + number;
    }

}
