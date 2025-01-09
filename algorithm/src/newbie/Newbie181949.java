package newbie;

import java.util.Scanner;

public class Newbie181949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] arr = a.toCharArray();

        //97보다 작으면 대문자임 -> 소문자 convert
        //97이상이면 소문자임 -> 대문자 convert
        for (char c : arr) {
            if((int) c < 97) {
                System.out.print((char) ((int) c + 32));
            }else {
                System.out.print((char) ((int) c - 32));
            }
        }
    }
}
