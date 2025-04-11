package newbie;

import java.util.Arrays;

/**
 * 정수 start_num와 end_num가 주어질 때,
 * start_num부터 end_num까지의 숫자를 차례로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
 */
public class Newbie181920 {
    public static void main(String[] args) {
        int[] result = solution(3, 10);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
    }

    public static int[] solution(int start_num, int end_num) {
        int[] arr = new int[end_num - start_num + 1];
        for(int i=0;i<=end_num-start_num;i++) {
            arr[i] = start_num + i;
        }
        return arr;
    }
}
