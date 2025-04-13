package newbie;

/**
 * 문자들이 담겨있는 배열 arr가 주어집니다.
 * arr의 원소들을 순서대로 이어 붙인 문자열을 return 하는 solution함수를 작성해 주세요.
 */
public class Newbie181941 {
    public static void main(String[] args) {
        String result = solution(new String[]{"a", "b", "c"});
        System.out.println("result = " + result);
    }

    public static String solution(String[] arr) {
        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}
