package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1406 {//풀이중
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayList<Character> ch = new ArrayList<>();
        //문자열 담기
        for (int i = 0; i < str.length(); i++) {
            ch.add(str.charAt(i));
        }
        int commendline = Integer.parseInt(br.readLine());
        int cuser = ch.size();

        for (int i = 0; i < commendline; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "L":

                    if (cuser == 0) {
                        cuser=0;
                    } else {
                        cuser -= 1;

                    }
                    break;
                case "D":
                    if(cuser == ch.size()){
                        cuser= ch.size();
                    }else{
                        cuser+=1;
                    }
                    break;
                case "B":
                    if(cuser == 0 ) continue;
                    ch.remove(cuser-1);
                    cuser--;
                    break;
                case "P":
                    char alpha = st.nextToken().charAt(0);
                    ch.add(cuser, alpha);
                    cuser++;
                    break;
            }
        }
        for (Character character : ch) {
            System.out.print(character);
        }
    }
}
