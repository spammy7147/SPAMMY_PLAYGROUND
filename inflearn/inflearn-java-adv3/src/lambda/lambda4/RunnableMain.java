package lambda.lambda4;

public class RunnableMain {
    public static void main(String[] args) {
        Runnable  runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello runnable");
            };
        };

        runnable1.run();

        Runnable runnable2 = () -> System.out.println("hello runnable");

        runnable2.run();
    }

}
