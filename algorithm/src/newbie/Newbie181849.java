package newbie;

public class Newbie181849 {
    public int solution(String num_str) {
        int answer = 0;
        for (char c : num_str.toCharArray()) {
            answer += Character.getNumericValue(c);
        }
        return answer;
    }
}
