package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 5525.IOIOI
 * 간단한 문제인줄 알았는데
 * substring으로 잘라서 하면 50점밖에 못얻는다
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

