package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2885 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str =bin(n);
        boolean one = false;
        int unit = 1;
        int size = 0;
        int pointer = 0;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='1'){
                if(one){
                    unit += i-pointer;
                }else{
                    one = true;
                }
                pointer =i;
            }
        }
       if(unit ==1){
           size = (int)Math.pow(2,str.length()-1);
           unit--;
       }else{
           size = (int)Math.pow(2,str.length());

       }
        System.out.println(size+" "+unit);
    }

    private static String bin(int n) {
        StringBuilder str = new StringBuilder();
        while(n>0){
            str.append(n % 2);
            n/=2;
        }
        return str.reverse().toString();
    }
}
