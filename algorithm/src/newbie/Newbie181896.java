package newbie;

/**
 * 정수 리스트 num_list가 주어질 때,
 * 첫 번째로 나오는 음수의 인덱스를 return하도록 solution 함수를 완성해주세요.
 * 음수가 없다면 -1을 return합니다.
 */
public class Newbie181896 {
    public static void main(String[] args) {
        int result = solution(new int[]{12, 4, 15, 46, 38, -2, 15});
        System.out.println("result = " + result);
    }

    public static int solution(int[] num_list) {
        for(int i=0;i<num_list.length;i++) {
            if(num_list[i] < 0) {
                return i;
            }
        }
        return -1;
    }
}
