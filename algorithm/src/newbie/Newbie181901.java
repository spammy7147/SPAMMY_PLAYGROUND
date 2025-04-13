package newbie;

/**
 * 정수 n과 k가 주어졌을 때,
 * 1 이상 n이하의 정수 중에서 k의 배수를 오름차순으로 저장한 배열을
 * return 하는 solution 함수를 완성해 주세요.
 */
public class Newbie181901 {
    public static void main(String[] args) {
        int[] result = solution(10, 3);
        System.out.println("result = " + result);
    }

    public static int[] solution(int n, int k) {
        int idx = 0;
        int[] answer = new int[n/k];
        for(int i=k;i<=n;i+=k) {
            answer[idx++] += i;
        }
        return answer;
    }
}
