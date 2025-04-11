package newbie;

/**
 * 연산 ⊕는 두 정수에 대한 연산으로 두 정수를 붙여서 쓴 값을 반환합니다. 예를 들면 다음과 같습니다.
 *
 * 12 ⊕ 3 = 123
 * 3 ⊕ 12 = 312
 * 양의 정수 a와 b가 주어졌을 때, a ⊕ b와 b ⊕ a 중 더 큰 값을 return 하는 solution 함수를 완성해 주세요.
 *
 * 단, a ⊕ b와 b ⊕ a가 같다면 a ⊕ b를 return 합니다.
 */

public class Newbie181939 {
    public static void main(String[] args) {
        int result = solution(9, 91);
        System.out.println("result = " + result);
    }

    public static int solution(int a, int b) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(a).append(b);
        sb2.append(b).append(a);

        return Math.max(Integer.parseInt(sb1.toString()), Integer.parseInt(sb2.toString()));
    }
}
