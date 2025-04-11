package newbie;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 정수 리스트 num_list와 정수 n이 주어질 때,
 * num_list를 n 번째 원소 이후의 원소들과 n 번째까지의 원소들로 나눠
 * n 번째 원소 이후의 원소들을 n 번째까지의 원소들 앞에 붙인 리스트를
 * return하도록 solution 함수를 완성해주세요.
 */
public class Newbie181891 {

    public static void main(String[] args) {
        int[] result = solution(new int[]{2, 1, 6}, 1);
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));

    }

    public static int[] solution(int[] num_list, int n) {
        return Stream.of(Arrays.copyOfRange(num_list,n,num_list.length), Arrays.copyOfRange(num_list,0,n))
                    .flatMapToInt(IntStream::of).toArray();
    }
}
