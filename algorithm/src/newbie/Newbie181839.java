package newbie;

public class Newbie181839 {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;

        if((a % 2 != 0) && (b % 2 != 0)) {
            System.out.println((a * a)+ (b * b));
        } else if ((a % 2 != 0) || (b % 2 != 0)) {
            System.out.println(2 * (a + b));
        }else {
            System.out.println(Math.abs(a - b));
        }
    }
}
