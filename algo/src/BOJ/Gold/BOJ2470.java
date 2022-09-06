package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int start = 0;
        int end = n-1;
        int pointer1 = 0;
        int pointer2 = 0;
        int sum = Integer.MAX_VALUE;

        while(start<end){
            if(Math.abs(arr[start]+arr[end])<sum){
                sum = Math.abs(arr[start]+arr[end]);
                pointer1 = arr[start];
                pointer2 = arr[end];
            }
            if(arr[start]+arr[end]<0){
                start++;
            }else {
                end--;
            }
        }
        System.out.println(pointer1 +" "+ pointer2);
    }
}
