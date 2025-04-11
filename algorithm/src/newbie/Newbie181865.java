package newbie;

/**
 * 문자열 binomial이 매개변수로 주어집니다.
 * binomial은 "a op b" 형태의 이항식이고 a와 b는 음이 아닌 정수, op는 '+', '-', '*' 중 하나입니다.
 * 주어진 식을 계산한 정수를 return 하는 solution 함수를 작성해 주세요.
 */
public class Newbie181865 {
    public static void main(String[] args) {
        int result = solution("43 + 12");
        System.out.println("result = " + result);
    }

    public static int solution(String binomial) {
        String[] arr = binomial.split(" ");
        switch(arr[1]) {
            case "+":
                return Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]);
            case "-":
                return Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]);
            case "*":
                return Integer.parseInt(arr[0]) * Integer.parseInt(arr[2]);
            default:
                return 0;
        }
    }
}
