package BOJ;

import javax.lang.model.element.NestingKind;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BOJ1236 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String data ="3 4\n" +
                "..X.\n" +
                "....\n" +
                ".X..";
        br= new BufferedReader(new StringReader(data));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];
        for (int i = 0; i <n ; i++) {
            String str=br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j]= str.charAt(j);
            }
        }
        boolean flag = true;
        int count1 =0;
        int count2 =0;
        int min =0;
        for (int i = 0; i < n; i++) {
            flag = true;
            for (int j = 0; j < m; j++) {
                if(map[i][j]=='X'){
                    flag=true;
                    break;
                }
                flag = false;
            }
            if(!flag)count1++;

        }
        for (int j = 0; j < m; j++) {
            flag = true;
            for (int i = 0; i < n; i++) {
                if(map[i][j]=='X'){
                    flag=true;
                    break;
                }
                flag = false;
            }
            if(!flag)count2++;
        }

        System.out.println(Math.max(count1,count2));
    }
}
