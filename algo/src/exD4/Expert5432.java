package exD4;

import java.util.Scanner;

public class Expert5432 {
    public static void main(String[] args) {
        String data ="\n" +
                "2\n" +
                "()(((()())(())()))(())\n" +
                "(((()(()()))(())()))(()())";
        Scanner sc = new Scanner(System.in);
        sc=new Scanner(data);
        int T=sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            String str = sc.next();
            int[] arr = new int[str.length()];
            //배열담기 성공
            for(int i=0;i<arr.length;i++){
                arr[i]=str.charAt(i);
            }

        }
    }
}
