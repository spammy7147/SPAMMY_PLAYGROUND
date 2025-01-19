package newbie;

import java.util.stream.IntStream;

/**
 * 정수로 이루어진 리스트 num_list가 주어집니다. num_list에서 가장 작은 5개의 수를 오름차순으로 담은 리스트를 return하도록 solution 함수를 완성해주세요.
 */
public class Newbie181853 {
    public int[] solution(int[] num_list) {
        return IntStream.of(num_list).sorted().limit(5).toArray();
    }
}
