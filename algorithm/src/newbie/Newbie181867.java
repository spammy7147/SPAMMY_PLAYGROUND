package newbie;

import java.util.ArrayList;
import java.util.List;

/**
 * 문자열 myString이 주어집니다.
 * myString을 문자 "x"를 기준으로 나눴을 때 나눠진 문자열 각각의 길이를 순서대로 저장한 배열을 return 하는 solution 함수를 완성해 주세요.
 */
public class Newbie181867 {
    public int[] solution(String myString) {
        List<Integer> answer = new ArrayList<>();
        for(String s : myString.split("x", -1)) {
            answer.add(s.length());
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
