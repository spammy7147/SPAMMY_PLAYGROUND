package newbie;

/**
 * 문자열 my_string과 정수 n이 매개변수로 주어질 때, 
 * my_string의 뒤의 n글자로 이루어진 문자열을 return 하는 solution 함수를 작성해 주세요.
 */
public class Newbie181910 {
    public static void main(String[] args) {
        String result = solution("ProgrammerS123", 11);
        System.out.println("result = " + result);
    }

    public static String solution(String my_string, int n) {
        return my_string.substring(my_string.length() - n);
    }
}
