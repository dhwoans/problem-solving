package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch < 'a') {
                ch += 32;
            }
                arr[(ch - 'a')]++;
        }
        int max=0;
        int answer =0;
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]>max){
                max=arr[j];
                answer =(char) (j+65);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(i==answer-65)continue;
            if(max==arr[i]){
                answer=0;
                break;
            }
        }
        if(answer==0){
            System.out.println("?");
        }else{

            System.out.println((char)answer);
        }
    }
}
