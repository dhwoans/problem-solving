package SWEA.ex;


import java.util.Scanner;

public class Expert1945 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        int e=0;
        //11이 나눠지는지 확인
        while(num%11==0){
            num/=11;
            e++;
        }
        //7
        while(num%7==0){
            num/=7;
            d++;
        }
        //5
        while(num%5==0){
            num/=5;
            c++;
        }
        //3
        while(num%3==0){
            num/=3;
            b++;
        }
        //2
        while(num%2==0){
            num/=2;
            a++;
        }
        System.out.printf("%d %d %d %d %d",a,b,c,d,e);
    }
}
