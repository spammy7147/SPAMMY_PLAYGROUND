package methodref;

import java.util.function.Function;
import java.util.function.Supplier;

public class MethodRefEx2 {
    public static void main(String[] args) {
        //1. 정적 메서드 참조
        Function<String,String> staticMethod1 = name -> Person.greetingWithName(name);
        Function<String,String> staticMethod2 = Person::greetingWithName;
        System.out.println("staticMethod1.get() = " + staticMethod1.apply("kim"));
        System.out.println("staticMethod2.get() = " + staticMethod2.apply("kim"));

        //2.특정 객체의 인스턴스 참조
        Person person = new Person("kim");
        Function<Integer,String> instanceMethod1 = n -> person.introduceWithNumber(n);
        Function<Integer,String> instanceMethod2 = person::introduceWithNumber;
        System.out.println("instanceMethod1.get() = " + instanceMethod1.apply(1));
        System.out.println("instanceMethod2.get() = " + instanceMethod2.apply(1));

        //3.생성자 참조
        Function<String, Person> constructorMethod1 = (name) -> new Person(name);
        Function<String, Person> constructorMethod2 = Person::new;
        System.out.println("constructorMethod1.get() = " + constructorMethod1.apply("kim"));
        System.out.println("constructorMethod2.get() = " + constructorMethod2.apply("kim"));
    }
}
