package lambda.ex2;

import javax.xml.namespace.QName;

public class BuildGreeterExample {

    public static StringFunction buildGreeter(String greeting) {
        return (name) -> greeting + ", " + name;
    }

    public static void main(String[] args) {
        StringFunction helloGreeter = buildGreeter("Hello");
        StringFunction hiGreeter = buildGreeter("Hi");
        System.out.println(helloGreeter.apply("Java"));
        System.out.println(hiGreeter.apply("Lambda"));
    }
}
