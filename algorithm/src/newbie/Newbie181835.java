package newbie;

public class Newbie181835 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 100, 99, 98};
        int k = 3;

        for(int i=0;i <arr.length;i++) {
            if(k % 2 == 0) {
                arr[i] = arr[i] + k;
            } else {
                arr[i] = arr[i] * k;
            }
        }

        System.out.println(arr);
    }
}
