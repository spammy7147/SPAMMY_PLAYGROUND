package methodref;

import lambda.lambda5.mystream.MyStreamV3;

import java.util.List;
import java.util.function.BiFunction;

//매개변수 추가
public class MethodRef6 {
    public static void main(String[] args) {
        //4. 임의 객체의 인스턴스 메서드 참조(특정 타입의)

        Person person = new Person("kim");

        BiFunction<Person, Integer, String> func1 = (Person p, Integer n) -> p.introduceWithNumber(n);

        System.out.println("person.introduceWithNumber = " + func1.apply(person, 1));


        //메서든 참조, 타입이 첫번쨰 매개변수가 됨, 그리고 첫번쨰 매개변수의 메서드를 호출
        //나머지는 순서대로 매개변수에 전달

        BiFunction<Person, Integer, String> func2 = Person::introduceWithNumber;
        System.out.println("person.introduceWithNumber = " + func2.apply(person, 1));
    }
}
