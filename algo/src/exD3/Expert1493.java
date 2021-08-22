package exD3;

import java.util.Scanner;

public class Expert1493 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data ="2\n" +
                "1 5\n" +
                "3 9";
        sc=new Scanner(data);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int val1=sc.nextInt();
            int val2=sc.nextInt();
            int m1=0;
            int m2=0;
            int n1=0;
            int n2=0;
            for (int m = 1; m <= 300; m++) {
                for (int n = 1; n <= 300; n++) {
                    if(val1==(2+m*(m-1)+(n-1)*(2*(m+1)+(n-2)))/2){
                        m1=m;
                        n1=n;
                    }
                     if(val2==(2+m*(m-1)+(n-1)*(2*(m+1)+(n-2)))/2){
                        m2=m;
                        n2=n;
                    }

                }
            }
            int m3 =m1+m2;
            int n3 =n1+n2;
            int value = (2+m3*(m3-1)+(n3-1)*(2*(m3+1)+(n3-2)))/2;
            System.out.printf("#%d %d\n",test_case,value);
        }


    }
}
