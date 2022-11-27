package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15992 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[][] arr= new long[1001][1001];
        StringBuilder sb = new StringBuilder();

        arr[1][1]=1;
        arr[1][2]=1;
        arr[1][3]=1;

        for(int i =2;i<arr.length;i++){
            for(int j=i;j<arr[i].length;j++){
                if(i==j){
                    arr[i][j]=1;
                    continue;
                }

                arr[i][j]+=arr[i-1][j-1]%1000000009;
                if(j>2)arr[i][j]+=arr[i-1][j-2]%1000000009;
                if(j>3)arr[i][j]+=arr[i-1][j-3]%1000000009;
            }
        }



        for(int i =0;i<t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());


            sb.append(arr[pos][val]%1000000009).append("\n");


        }

        System.out.println(sb);
    }
}
