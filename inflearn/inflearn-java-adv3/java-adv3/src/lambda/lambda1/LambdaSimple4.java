package lambda.lambda1;

import lambda.MyFunction;

public class LambdaSimple4 {
    public static void main(String[] args) {
        //기본
        MyCall call1 = (int value) -> value * 2;
        MyCall call2 = (value) -> value * 2;
        MyCall call3 = value -> value * 2;
        System.out.println("call3 = " + call3.call(2));

    }
    interface MyCall {
        int call(int value);
    }
}
