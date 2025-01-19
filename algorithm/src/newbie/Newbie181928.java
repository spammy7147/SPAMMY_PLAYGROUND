package newbie;

public class Newbie181928 {
        public int solution(int[] num_list) {
            String odd = "0";
            String even = "0";
            for(int i : num_list) {
                if(i % 2 == 0) {
                    even += Integer.toString(i);
                } else{
                    odd += Integer.toString(i);
                }
            }
            int answer = Integer.parseInt(odd) + Integer.parseInt(even);
            return answer;
        }
}
