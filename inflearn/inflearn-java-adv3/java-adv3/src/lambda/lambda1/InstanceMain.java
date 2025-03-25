package lambda.lambda1;

import lambda.Procedure;

public class InstanceMain {
    public static void main(String[] args) {
        Procedure procedure1 = new Procedure() {
            @Override
            public void run() {
                System.out.println("hello! lambda");
            }
        };

        System.out.println("procedure1.getClass() = " + procedure1.getClass());
        System.out.println("procedure1 = " + procedure1);

        Procedure procedure2 = () -> {
            System.out.println("hello lambda");
        };

        System.out.println("procedure2.getClass() = " + procedure2.getClass());
        System.out.println("procedure2 = " + procedure2);
    }
}
