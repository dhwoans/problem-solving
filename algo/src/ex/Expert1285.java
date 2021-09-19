package ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Expert1285 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input1285.txt"));
        Scanner sc = new Scanner(System.in);

        int T =sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
        int[] arr = new int[100001];
            int count =sc.nextInt();
            for(int i=0;i<count;i++){
                arr[Math.abs(sc.nextInt())]++;
            }

        for(int x=0;x<arr.length;x++){
            if(arr[x]>0){
                System.out.printf("#%d %d %d\n",test_case,x,arr[x]);
                break;
            }
        }
        }
    }
}
