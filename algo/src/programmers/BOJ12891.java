package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @packageName : programmers
 * @fileName : BOJ12891
 * @date : 2021-12-26
 * @language : JAVA
 * @classification : sliding window
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());                   // DNA 문자열 길이
        int P = Integer.parseInt(st.nextToken());                   // 부분 문자열 길이
        int answer =0;
        ArrayList<Character> sum = new ArrayList<>();
        char[] str = new char[S];
        int[] DNA = new int[4];

        String strr = br.readLine();
        for (int i = 0; i < str.length; i++) {
            str[i] = strr.charAt(i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < DNA.length; i++) {
            DNA[i]=Integer.parseInt(st.nextToken());
        }

        for (int end = 0; end < str.length; end++) {
            sum.add(str[end]);
            if(end>=P-1){
                if(Check(sum,DNA)){
                    answer++;
                }
                sum.remove(0);
                
            }
        }
        System.out.println(answer);
    }

    private static boolean Check(ArrayList<Character> sum,int[] DNA) {
        char[] DNAstr ={'A', 'C', 'G', 'T'};
        int[] check = new int[4];
        for (int i = 0; i < sum.size(); i++) {
            check[Arrays.binarySearch(DNAstr,sum.get(i))]++;
        }
        if(Arrays.equals(DNA,check)){
            return true;
        }
        return false;
    }
}
