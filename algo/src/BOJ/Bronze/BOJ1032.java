package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();
        char[] ch = new char[str.length()];
        for (int i = 0; i < ch.length; i++) {
            ch[i]=str.charAt(i);
        }

        for (int i = 0; i < num-1; i++) {
           String str1 = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                if(ch[j]== str1.charAt(j)){
                   ch[j]=str.charAt(j);
                }else{
                    ch[j]='?';
                }
            }

        }
        for (char c : ch) {
            System.out.print(c);
        }

    }
}
