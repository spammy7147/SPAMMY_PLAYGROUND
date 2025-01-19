package newbie;

import java.util.stream.IntStream;

/**
 * 정수가 담긴 리스트 num_list가 주어질 때,
 * 리스트의 길이가 11 이상이면 리스트에 있는 모든 원소의 합을 10 이하이면 모든 원소의 곱을 return하도록 solution 함수를 완성해주세요.
 */
public class Newbie181879 {
    public int solution(int[] num_list) {
        return num_list.length > 10 ? IntStream.of(num_list).sum() : IntStream.of(num_list).reduce(1, (a, b) -> a * b);
    }
}
}
