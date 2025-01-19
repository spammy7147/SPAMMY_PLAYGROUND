package newbie;

public class Newbie181935 {
    public int solution(int n) {
        if(n % 2 != 0) {
            return (((n/2) + 1) * ((n/2) + 1));
        } else {
            return ((n * n + 2 * n) * (n + 1)) / 6;
        }
    }
}
