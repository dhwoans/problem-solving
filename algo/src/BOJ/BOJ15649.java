package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ15649 {
    static int m,n;
    static int[] arr;
    static boolean[] iselected;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=4;
        m=2;
        arr = new int[m];
        iselected =new boolean[n+1];


        permutation(0);

    }
    private static void permutation(int cnt) {
        if(cnt == m) {
            for(int x:arr){
                System.out.print(x+" ");
            }
            System.out.println();
            return;
        }
        //가능한 모든 수 시도
        for(int i=1;i<=n;i++) {
            if(iselected[i]) continue; // 사용중이 수면 다음 수로

            arr[cnt] = i;
            iselected[i] = true;

            //다음 자리순열 뽑으러
            permutation(cnt+1);
            iselected[i] = false;
        }
    }
}
