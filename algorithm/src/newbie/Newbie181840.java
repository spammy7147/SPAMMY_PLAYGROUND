package newbie;

public class Newbie181840 {
    public int solution(int[] num_list, int n) {
        for (int i : num_list) {
            if(n == i) {
                return 1;
            }
        }
        return 0;
    }
}
