package BOJ.Gold;

import java.util.Scanner;

public class BOJ2639 {

    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr = new int[10_001];
        int count = 0;

        while (sc.hasNext()) {
            arr[count++] = sc.nextInt();
        }
        postOrder(0, count - 1);
    }

    private static void postOrder(int n, int end) {
        if (n > end) {
            return;
        }
        int mid = n + 1;
        while (mid <= end && arr[mid] < arr[n]) {
            mid++;
        }

        postOrder(n + 1, mid - 1);
        postOrder(mid, end);
        System.out.println(arr[n]);
    }
}
