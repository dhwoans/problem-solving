package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1063 {//풀이중
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String dol = st.nextToken();
        int num =Integer.parseInt(st.nextToken());

        //좌표로 바꿈
        int[] kingpos = new int[2];
        int[] dolpos = new int[2];

        kingpos[0] = (king.charAt(0)-'A')+1;
        kingpos[1] = king.charAt(1)-'0';

        dolpos[0]  = (dol.charAt(0)-'A')+1;
        dolpos[1]  =  dol.charAt(1)-'0';

        //방향이동
        for (int i = 0; i < num; i++) {
            String command = br.readLine();
            //대각선일경우
            if(command.length()==2){
                for (int j = 0; j < 2; j++) {
                    char ch = command.charAt(j);

                }
            }

        }

    }
}
