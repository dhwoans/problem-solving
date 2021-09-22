package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int R=1;
        int C=str.length();
        int row =0;
        int col =0;

        for (int i = R; i <=str.length() ; i++) {
            for (int j = C; j >1 ; j--) {
                if(i>j)break;
                if(i*j==C){
                    row = i;
                    col = j;
                    break;
                }

            }

        }
        char[][] map = new char[row][col];
        int n=0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                map[j][i]=str.charAt(n++);
            }
        }
        for (char[] chars : map) {
            for (char i : chars) {
                System.out.print(i);
            }
        }
    }
}
