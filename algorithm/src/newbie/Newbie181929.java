package newbie;

/**
 * 정수가 담긴 리스트 num_list가 주어질 때,
 * 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 크면 0을 return하도록 solution 함수를 완성해주세요.
 */

public class Newbie181929 {
    public static void main(String[] args) {
        int result = solution(new int[]{3, 4, 5, 2, 1});
        System.out.println("result = " + result);
    }

    public static int solution(int[] arr) {
        int multi = 1;
        int sum = 0;
        for(int i : arr) {
            multi *= i;
            sum += i;
        }
        return multi > (sum * sum) ? 0 : 1;
    }
}
