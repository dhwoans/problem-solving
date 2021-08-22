package BOJ;

import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int arr[] = new int[10];
        while(true){
            int num = sc.nextInt();
            if(num==0) break;
            arr[num/10]++;


        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0) continue;
            System.out.printf("%d: %d개\n",i,arr[i]);
        }
    }
}
