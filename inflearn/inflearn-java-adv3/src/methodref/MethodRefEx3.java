package methodref;

import java.util.function.Function;

public class MethodRefEx3 {
    public static void main(String[] args) {
        //4. 임의 객체의 인스턴스 매서드 참조(특정 타입의)
        Person person1 = new Person("kim");
        Person person2 = new Person("lee");
        Person person3 = new Person("park");

        //람다
        Function<Person, String> function1 = (person) -> person.introduce();
        System.out.println("function1.apply(person1) = " + function1.apply(person1));
        System.out.println("function1.apply(person2) = " + function1.apply(person2));
        System.out.println("function1.apply(person3) = " + function1.apply(person3));

        //메서드 참조, 타입이 첫번쨰 매개번수가 됨
        // 첫번째 매개변수의 메서드를 호출, 나머지는 순서대로 매개변수에 전달
        Function<Person, String> function2 = Person::introduce; //타입::인스턴스메서드
        System.out.println("function2.apply(person1) = " + function2.apply(person1));
        System.out.println("function2.apply(person2) = " + function2.apply(person2));
        System.out.println("function2.apply(person3) = " + function2.apply(person3));


    }
}
