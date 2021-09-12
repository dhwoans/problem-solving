package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =Integer.parseInt(st.nextToken());
        int M =Integer.parseInt(st.nextToken());
        int L =Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        boolean flag = true;
        arr[0]++;
        int z=0;
        while (flag) {
            if(arr[z]%2!=0){
                if(z+L>=N){
                    z=z+L-N;
                    arr[z]++;
                }else{
                    z=z+L;
                    arr[z]++;
                }

            }else{
                if(z-L<0){
                    z=z-L+N;
                    arr[z]++;
                }else{
                    z=z-L;
                    arr[z]++;
                }
            }
            for (int i : arr) {
                if (i==M){
                    flag=false;
                }
            }
        }
        int sum=0;
        for (int i : arr) {
            sum+=i;
        }
        System.out.println(sum-1);
    }
}
