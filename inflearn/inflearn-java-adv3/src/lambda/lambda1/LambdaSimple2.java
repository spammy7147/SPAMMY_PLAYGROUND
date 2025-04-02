package lambda.lambda1;

import lambda.MyFunction;
import lambda.Procedure;

public class LambdaSimple2 {
    public static void main(String[] args) {
        //기본
        Procedure procedure1 = () -> {
            System.out.println("hello! lambda");
        };
        procedure1.run();

        Procedure procedure2 = () -> System.out.println("hello lambda");
        procedure2.run();
    }
}
