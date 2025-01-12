package newbie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Newbie181844 {
    public int[] solution(int[] arr, int[] delete_list) {
        List<Integer> answer = new ArrayList<>();
        for (int i : arr) {
            boolean isDeleted = false;
            for (int j : delete_list) {
                if(i == j) {
                    isDeleted = true;
                }
            }
            if(!isDeleted) {
                answer.add(i);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
