package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @packageName : BOJ.Gold
 * @fileName : BOJ20437
 * @date : 2021-12-27
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 * 알파벳 별로 개수를 입력받는다
 **/
public class BOJ20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            char[] str = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());
            int start = 0;

            HashMap<Character, Integer> map = new HashMap<>();

            for (int end = 0; end < str.length; end++) {
                map.put(str[end],map.getOrDefault(str[end],0)+1);

                if(map.size()>=K){
                    //K개 포함되었는지 확인

                }
            }


        }


    }
}
