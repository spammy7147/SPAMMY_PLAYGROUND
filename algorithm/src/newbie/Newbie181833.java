package newbie;

import java.util.Arrays;

/**
 * 정수 n이 매개변수로 주어질 때, 다음과 같은 n × n 크기의 이차원 배열 arr를 return 하는 solution 함수를 작성해 주세요.
 * arr[i][j] (0 ≤ i, j < n)의 값은 i = j라면 1, 아니라면 0입니다.
 */
public class Newbie181833 {
    public static void main(String[] args) {
        int[][] result = solution(3);
        System.out.println("Arrays.deepToString(result) = " + Arrays.deepToString(result));
    }
    public static int[][] solution(int n) {
        int[][] ans = new int[n][n];
        for(int i=0;i<n;i++) {
            int[] q = new int[n];
            q[i] = 1;
            ans[i] = q;
        }
        return ans;
    }
}
