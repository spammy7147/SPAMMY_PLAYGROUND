package lambda.lambda1;

import lambda.MyFunction;
import lambda.Procedure;

public class LambdaSimple3 {
    public static void main(String[] args) {
        //기본
        MyFunction myFunction1 = (int a, int b) ->  a + b;
        System.out.println("myFunction1.apply(1,2) = " + myFunction1.apply(1, 2));

        MyFunction myFunction2 = (a,b) -> a + b;
        System.out.println("myFunction2.apply(1,2) = " + myFunction2.apply(1, 2));
    }
}
