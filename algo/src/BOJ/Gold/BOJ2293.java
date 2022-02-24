package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2293 {

    private static int[] arr;
    private static int s;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }

        int start =0;
        int end =0;
        int amount =arr[0];
        int answer = Integer.MAX_VALUE;
        while(true){

            if(amount>=s){
                answer = Math.min(start - end + 1,answer);
                amount-=arr[end++];
            }
            else if(amount<s){
                start++;
                if(start>=arr.length)break;
                amount+=arr[start];
            }
        }
        if(answer==Integer.MAX_VALUE)answer=0;
        System.out.println(answer);
    }
}
