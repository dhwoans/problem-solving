package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer=0;

        while(true){
            int cnt =0;
            String str =  Integer.toBinaryString(n);
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i)=='1')cnt++;
            }
            if(cnt<=k){
                System.out.println(answer);
                return;
            }
            answer++;
            n++;
        }


    }
}
