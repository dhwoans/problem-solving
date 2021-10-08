package SWEA.exD3;

import java.util.Scanner;

public class Expert3314 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = 5;
            int arr[] =new int[N];
            int sum=0;
            for (int i = 0; i < arr.length; i++) {
                arr[i]=sc.nextInt();
                if(arr[i]<40)arr[i]=40;
                sum+=arr[i];
            }
            System.out.println("#"+test_case+" "+(sum/N));
        }
    }
}
