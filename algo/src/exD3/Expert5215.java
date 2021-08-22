package exD3;

import java.util.Scanner;

public class Expert5215 {
    static  int n,r;
    static  int score[];
    static  int kal[];
    static  boolean isSelect[];
    static  int max;
    static  StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String data ="1\n" +
//                "5 1000\n" +
//                "100 200\n" +
//                "300 500\n" +
//                "250 300\n" +
//                "500 1000\n" +
//                "400 400";
//        sc =new Scanner(data);
        int T=sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            max=Integer.MIN_VALUE;
            n=sc.nextInt();
            r=sc.nextInt();
            score=new int[n];
            kal=new int[n];
            isSelect=new boolean[n];

            for(int i=0;i<n;i++){
                score[i] = sc.nextInt();
                kal[i]= sc.nextInt();



            }
            dfs(0);
            System.out.println("#"+test_case+" "+max);


        }

    }
    static void dfs(int cnt){

        if(cnt==n){
            int sumk=0;
            int sums=0;
            for (int i = 0; i < n; i++) {
//                System.out.printf((isSelect[i]?kal[i]:"x")+" ");
                if(isSelect[i]) {
                    sumk += kal[i];
                    sums += score[i];
                }
            }
//            System.out.println();
//            System.out.println("칼로리 총합 :"+sumk);
//            System.out.println("맛 점수:"+sums);
            if(sumk<r)
            max= Math.max(max,sums);

            return;
        }
        isSelect[cnt]=true;
        dfs(cnt+1);
        isSelect[cnt]=false;
        dfs(cnt+1);
    }

}
