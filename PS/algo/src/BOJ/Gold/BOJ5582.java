package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ5582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String s= br.readLine();
        String t= br.readLine();
        int[][] map = new int[s.length()+1][t.length()+1];
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                if(s.charAt(i-1)==t.charAt(j-1))map[i][j]=map[i-1][j-1]+1;
            }
        }
        int result =Arrays.stream(map).flatMapToInt(Arrays::stream).max().getAsInt();
        System.out.println(result);
    }
}
