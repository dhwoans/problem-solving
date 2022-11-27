package SWEA.ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Expert2063 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("C:\\test\\algo\\src\\input2063.txt"));

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        //배열에 담기
        int arr[] = new int[t];
        for(int i=0;i<t;i++){
            arr[i]=sc.nextInt();
        }
        //정렬하기
        for(int i=0;i<arr.length-1;i++){
            for(int j=1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp= arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;


                }
            }
        }
                System.out.println("arr = " + arr[(t/2)+1]);
    }
}
