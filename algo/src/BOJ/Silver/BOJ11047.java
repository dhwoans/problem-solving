package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr,Collections.reverseOrder());
        int coin =0;
        int num=0;
        while(true){
            if(k==0)break;
            if(k>=arr[num]){
                coin+=k/arr[num];
                k%=arr[num];
            }else{
                num++;
            }
        }
        System.out.println(coin);
    }
}
