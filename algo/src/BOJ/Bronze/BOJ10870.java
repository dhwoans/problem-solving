package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10870 {
    static int arr[]=new int[90];
    static int memo(int z){
        for (int i = 3; i < 90; i++) {
            arr[i]=arr[i-2]+arr[i-1];
        }
       return arr[z];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        arr[0]=0;
        arr[1]=1;
        arr[2]=1;
        int T = Integer.parseInt(br.readLine());
        System.out.println(memo(T));
    }
}
