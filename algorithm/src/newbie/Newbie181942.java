package newbie;

/**
 * 길이가 같은 두 문자열 str1과 str2가 주어집니다.
 * 두 문자열의 각 문자가 앞에서부터 서로 번갈아가면서 한 번씩 등장하는 문자열을 만들어 return 하는 solution 함수를 완성해 주세요.
 */
public class Newbie181942 {

    public static void main(String[] args) {
        String result = solution("aaaaa", "bbbbb");
        System.out.println("result = " + result);
    }

    public static String solution(String str1, String str2) {
        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            sb.append(str1Arr[i]).append(str2Arr[i]) ;
        }
        return sb.toString();
    }
}
