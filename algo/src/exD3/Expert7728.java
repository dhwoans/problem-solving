package exD3;

import java.util.Scanner;

public class Expert7728 {
    public static void main(String[] args) {
        String data = "2\n" +
                "1512\n" +
                "20170310";
        Scanner sc = new Scanner(System.in);
        sc=new Scanner(data);

        int T =sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            String str= sc.next();
            int[] arr = new int[10];
            for(int i=0;i<str.length();i++){
                arr[Character.getNumericValue(str.charAt(i))]++;
            }
            int count= 0;
            for(int x:arr){
                if(x>0){
                    count++;
                }
            }
            System.out.printf("#%d %d\n",test_case,count);
        }
    }
}
