package newbie;


/**
 * 문자열 my_string과 정수 배열 index_list가 매개변수로 주어집니다.
 * my_string의 index_list의 원소들에 해당하는 인덱스의 글자들을 순서대로 이어 붙인 문자열을
 * return 하는 solution 함수를 작성해 주세요.
 */
public class Newbie181915 {
    public static void main(String[] args) {
        String result = solution("cvsgiorszzzmrpaqpe", new int[]{16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7});
        System.out.println("result = " + result);
    }
    public static String solution(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();
        char[] myStringArr = my_string.toCharArray();
        for (int i : index_list) {
            sb.append(myStringArr[i]);
        }

        return sb.toString();
    }
}
