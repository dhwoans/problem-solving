package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] map = new int[1000];
        for (int i = 0; i < 500; i++) {
            for (int j = 0; j < map.length; j++) {
                if(j>=1+(a+b)*i&&j<=a+(a+b)*i){
                    map[j]++;
                }
                if(j>=1+(c+d)*i&&j<=c+(c+d)*i){
                    map[j]++;
                }

            }

        }
        System.out.println(map[p]+" "+map[n]+" "+map[m]);
    }
}
