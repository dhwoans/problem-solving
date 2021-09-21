package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] arr = new int[T][];
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i]=new int[2];
            for (int j = 0; j < 2; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][j]=n;
            }

        }
        for (int i = 0; i < T; i++) {
        int count =1;
            for (int j = 0; j < T; j++) {
                if(i==j)continue;
                if(arr[i][0]<arr[j][0]&&arr[i][1]<arr[j][1]){
                    count++;
                }
            }
            System.out.print(count+" ");

        }
    }
}
