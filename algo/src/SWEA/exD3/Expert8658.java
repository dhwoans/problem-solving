package SWEA.exD3;

import java.util.Scanner;

public class Expert8658 {
    public static void main(String[] args) {
        String data ="2\n" +
                "182 371 29 49 28 21 928 11 5 1\n" +
                "13 400 3010 2011 1111 40 4 103 301 100111";

        Scanner sc = new Scanner(System.in);
        sc=new Scanner(data);

        int T =sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
                int max =Integer.MIN_VALUE;
                int min =Integer.MAX_VALUE;
            //10개들어옴
            for(int i=0;i<10;i++){
                int num =sc.nextInt();
                int sum =0;

                while(num!=0){
                    sum+=num%10;
                    num/=10;
                }
                max=Math.max(max,sum);
                min= Math.min(min,sum);

            }
                System.out.printf("#%d %d %d\n",test_case,max,min);
        }
    }
}
