package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ9549
 * @date : 2021-12-28
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class BOJ9549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String crypto = br.readLine();
            int start =0;
            boolean flag = false;
            HashMap<Character, Integer> map = new HashMap<>();
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                map.put(str.charAt(j),map.getOrDefault(str.charAt(j),0)+1);
            }
            for (int end = 0; end < crypto.length(); end++) {
                if(map.containsKey(crypto.charAt(end))){
                    map.put(crypto.charAt(end),map.get(crypto.charAt(end))-1);
                }
                if(end>=str.length()-1){
                    for (Integer value : map.values()) {
                        if(value>0){
                            flag = false;
                            break;
                        }else{
                            flag = true;
                        }
                    }
                    if(map.containsKey(crypto.charAt(start))) {
                        map.put(crypto.charAt(start), map.get(crypto.charAt(start))+ 1);
                    }
                    start++;
                }
                if(flag){
                    System.out.println("YES");
                    break;
                }
            }
            if(!flag) System.out.println("NO");

        }
    }
}
