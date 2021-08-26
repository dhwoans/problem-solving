package exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Expert5356 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            char[][] map = new char[5][16];
            //문자열 5개받기
            for (int i = 0; i < map.length; i++) {
                String str= br.readLine();
                for (int j = 0; j < str.length(); j++) {
                    map[i][j]=str.charAt(j);
                }
            }
            System.out.print("#"+test_case+" ");
            for (int c = 0; c <16; c++) {
                for (int r = 0; r < map.length; r++) {
                    if(map[r][c]==0)continue;
                    System.out.print(map[r][c]);

                }
            }
            System.out.println();

        }
    }
}
