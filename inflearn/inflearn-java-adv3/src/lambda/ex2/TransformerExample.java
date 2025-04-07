package lambda.ex2;

public class TransformerExample {

    private static MyTransformer compose(MyTransformer t1, MyTransformer t2) {
        return s -> t2.transform(t1.transform(s));
    }

    public static void main(String[] args) {
        MyTransformer toUpper = s -> s.toUpperCase();
        MyTransformer addDeco = s -> "**" + s + "**";

        MyTransformer composeFunc = compose(toUpper, addDeco);

        String hello = composeFunc.transform("hello");

    }
}
