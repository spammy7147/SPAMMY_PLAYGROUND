package newbie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 정수 리스트 num_list와 정수 n이 주어질 때,
 * num_list의 첫 번째 원소부터 마지막 원소까지 n개 간격으로 저장되어있는 원소들을 차례로 담은 리스트를
 * return하도록 solution 함수를 완성해주세요.
 */
public class Newbie181888 {
    public static void main(String[] args) {
        int[] result = solution(new int[]{4, 2, 6, 1, 7, 6}, 2);
        System.out.println("result = " + Arrays.toString(result));
    }

    public static int[] solution(int[] num_list, int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<num_list.length;i+=n) {
            ans.add(num_list[i]);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
