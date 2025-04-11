package newbie;

public class Newbie181899 {
    /**
     * 정수 start_num와 end_num가 주어질 때,
     * start_num에서 end_num까지 1씩 감소하는 수들을 차례로 담은 리스트를
     * return하도록 solution 함수를 완성해주세요.
     */
    public static void main(String[] args) {
        int[] result = solution(10, 3);
        System.out.println("result = " + result);
    }

    public static int[] solution(int start_num, int end_num) {
        int length = start_num - end_num + 1;
        int[] answer = new int[length];
        for(int i=0;i<length;i++) {
            answer[i] = start_num--;
        }
        return answer;
    }
}
