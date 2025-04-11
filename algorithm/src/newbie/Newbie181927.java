package newbie;

import java.util.Arrays;

/**
 * 정수 리스트 num_list가 주어질 때,
 * 마지막 원소가 그전 원소보다 크면 마지막 원소에서 그전 원소를 뺀 값을
 * 마지막 원소가 그전 원소보다 크지 않다면 마지막 원소를 두 배한 값을 추가하여
 * return하도록 solution 함수를 완성해주세요.
 */
public class Newbie181927 {
    public static void main(String[] args) {
        int[] result = solution(new int[]{2, 1, 6});
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }

    public static int[] solution(int[] arr) {
        int lastIdx = arr.length-1;
        int[] ans = Arrays.copyOf(arr,lastIdx+2);
        ans[ans.length-1] = arr[lastIdx] > arr[lastIdx-1] ? arr[lastIdx] - arr[lastIdx-1] : arr[lastIdx] * 2;
        return ans;
    }
}
