package BOJ.Silver;

import java.util.Scanner;

public class BOJ15651 {
    static int m,n;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        m=sc.nextInt();
        arr = new int[m];



        permutation(0);
        System.out.println(sb);

    }
    private static void permutation(int cnt) {
        if(cnt == m) {
            for(int x:arr){
              sb.append(x+" ");
            }
            sb.append("\n");
            return;
        }
        //가능한 모든 수 시도
        for(int i=1;i<=n;i++) {


            arr[cnt] = i;


            //다음 자리순열 뽑으러
            permutation(cnt+1);

        }
    }
}
