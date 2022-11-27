package BOJ.Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class BOJ1786 {

    private static String pattern;
    private static String text;
    private static int[] index;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        text = br.readLine();
        pattern = br.readLine();
        index = new int[pattern.length()];

        //접두사 접미사
        int idx =0;
        for (int i = 1; i < index.length; i++) {
            // 맞는 위치 나올때까지 -1
            while (idx>0 && pattern.charAt(i) != pattern.charAt(idx)){
                idx= index[idx-1];
            }
            // 맞으면
            if(pattern.charAt(i)== pattern.charAt(idx)){
                idx+=1;
                index[i]=idx;
            }
        }
        //KMP
        kmp();
    }

    private static void kmp() {
        int result =0;
        ArrayList<Integer> list = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < text.length(); i++) {

            while (j>0&&text.charAt(i)!=pattern.charAt(j)){
                j = index[j-1];
            }
            if(text.charAt(i) == pattern.charAt(j)){
                if(j== pattern.length()-1){
                    result++;
                    list.add(i-j+1);
                    j=index[j];
                }else j+=1;
            }
        }
        System.out.println(result);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
