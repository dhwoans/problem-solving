package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];

        int upDown =0;
        int front =0;
        int back =0;
        int left =0;
        int right =0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]!=0)upDown++;
                //왼
                if(j==0)left+=map[i][j];
                else if(map[i][j-1]<map[i][j])left+=map[i][j]-map[i][j-1];
            }
        }
        upDown *=2;
        //오른
        for (int i = 0; i < n ; i++) {
            for (int j = m-1; j >=0 ; j--) {
                if(j==m-1)right+=map[i][j];
                else if(map[i][j]>map[i][j+1])right+=map[i][j]-map[i][j+1];
            }
        }
        //front
        for (int i = 0; i < m; i++) {
            for (int j = n-1; j >= 0; j--) {
                if(j==n-1)front+=map[j][i];
                else if(map[j][i]>map[j+1][i])front+=map[j][i]-map[j+1][i];
            }
        }

        //back
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(j==0)back+=map[j][i];
                else if(map[j][i]>map[j-1][i])back+=map[j][i]-map[j-1][i];
            }
        }
        int answer = upDown + front + back + left + right;
        System.out.println(answer);
    }
}

