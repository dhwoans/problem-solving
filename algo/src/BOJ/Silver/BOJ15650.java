package BOJ.Silver;


import java.util.Scanner;

public class BOJ15650 {
    static int n,r;
    static int arr[];
    static int input[];
    static boolean isSelect[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        r=sc.nextInt();

        input=new int[r];
        isSelect=new boolean[n+1];


        permutation(0,1);

    }
    static void permutation(int cnt,int i){

        if(r==cnt){

           for(int x: input){
               System.out.printf("%d ",x);
           }
            System.out.println();
            return;
        }
        for(;i<=n;i++){
            if(isSelect[i]) continue;

            input[cnt] = i;
            isSelect[i] = true;

            permutation(cnt +1,i+1);
            isSelect[i]=false;


        }

    }
}
