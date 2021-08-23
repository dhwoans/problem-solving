package BOJ;

import java.util.Scanner;

public class BOJ1002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data ="3\n" +
                "0 0 13 40 0 37\n" +
                "0 0 3 0 7 4\n" +
                "1 1 1 1 1 5";
        sc=new Scanner(data);
        int T =sc.nextInt();
        for (int i = 0; i < T; i++) {
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            int r1=sc.nextInt();
            int x2=sc.nextInt();
            int y2=sc.nextInt();
            int r2=sc.nextInt();
            int answer =0;
            double dis =Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
            if(r1>r2){
                int temp=r1;
                r1=r2;
                r2=temp;
            }
             if(dis==0&&r1==r2){
                answer=-1;
            }else if(dis==r1+r2||dis==r2-r1){
                answer=1;
            }else if(dis<r2-r1||dis>r2+r1||dis==0){
                answer=0;
            }else{
                 answer=2;
             }
            System.out.println(answer);
        }
    }
}
