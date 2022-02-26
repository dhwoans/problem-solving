package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 5525.IOIOI
 *
 *
 *
 */
public class BOJ5525 {//풀이중
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String p = "IOI";
        //배열늘리기
        for (int i = 1; i < n; i++) {
            p += "OI";
        }
        int count=0;
        for (int i = 0; i <= m-p.length(); i++) {
            if(s.charAt(i)=='O')continue;
           if(s.substring(i,i+p.length()).equals(p)){
               count++;
           }
        }
        System.out.println(count);
    }
    

}

