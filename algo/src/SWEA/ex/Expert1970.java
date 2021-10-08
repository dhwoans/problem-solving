package SWEA.ex;

import java.util.Scanner;

public class Expert1970 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data ="2 \n" +
                "32850\n" +
                "160 ";
        sc=new Scanner(data);
        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            //거스름돈 값 받기
            int num=sc.nextInt();
            int a=0;
            int b=0;
            int c=0;
            int d=0;
            int e=0;
            int f=0;
            int g=0;
            int h=0;

            //50,000원
            while (num>=50000){
                num-=50000;
                a++;
            }
            //10,000원
            while (num>=10000){
                num-=10000;
                b++;
            }
            //5,000원
            while (num>=5000){
                num-=5000;
                c++;
            }
            //1,000원
            while (num>=1000){
                num-=1000;
                d++;
            }
            //500원
            while (num>=500){
                num-=500;
                e++;
            }
            //100원
            while (num>=100){
                num-=100;
                f++;
            }
            //50원
            while (num>=50){
                num-=50;
                g++;
            }
            //10원
            while (num>=10){
                num-=10;
                h++;
            }
            System.out.printf("%d %d %d %d %d %d %d %d",a,b,c,d,e,f,g,h);
            System.out.println();
        }
    }
}
