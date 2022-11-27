package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1783 {

    static int[][] dir={{-2,1},{-1,2},{2,1},{1,2}};
    private static int answer;
    private static int c;
    private static int r;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        int answer =1;
        //세로 1일때
        if(c==1) answer = 1;
        //세로 2일때
        else if(c==2) answer = Math.min(4,(r+1)/2);
        //가로 7미만
        else if(r<7) answer = Math.min(4,r);
        //그외
        else answer = r-7+5;

        System.out.println(answer);
    }
}
