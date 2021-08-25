package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] men = new int[1000];
        int[] women = new int[1000];
        for (int i = 0; i < T; i++) {
            st= new StringTokenizer(br.readLine());
            if(st.nextToken().equals("1")){
                men[Integer.parseInt(st.nextToken())]++;
            }else {
                women[Integer.parseInt(st.nextToken())]++;
            }
        }
        int count =0;
        for (int i = 0; i < men.length; i++) {
            if (men[i] != 0) {
                count += men[i] / k;
                men[i] %= k;
                if (men[i] != 0) {
                    count++;
                }
            }
            if(women[i]!=0){
                count+=women[i]/k;
                women[i]%=k;
                if(women[i]!=0){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
