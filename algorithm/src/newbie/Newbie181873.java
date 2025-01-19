package newbie;

/**
 * 영소문자로 이루어진 문자열 my_string과 영소문자 1글자로 이루어진 문자열 alp가 매개변수로 주어질 때,
 * my_string에서 alp에 해당하는 모든 글자를 대문자로 바꾼 문자열을 return 하는 solution 함수를 작성해 주세요.
 */
public class Newbie181873 {
    public String solution(String my_string, String alp) {
        StringBuilder sb = new StringBuilder();
        for(char c : my_string.toCharArray()) {
            if( c == alp.charAt(0)) {
                c -= 32;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
