package newbie;

import java.util.Arrays;

/**
 * 정수 리스트 num_list와 정수 n이 주어질 때,
 * n 번째 원소부터 마지막 원소까지의 모든 원소를 담은 리스트를
 * return하도록 solution 함수를 완성해주세요.
 */
public class Newbie181892 {
    public static void main(String[] args) {
        int[] result = solution(new int[]{2, 1, 6}, 3);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }

    public static int[] solution(int[] num_list, int n) {
        return Arrays.copyOfRange(num_list, n - 1, num_list.length);
    }
}
