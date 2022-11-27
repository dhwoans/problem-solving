package BOJ.Silver;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @packageName : BOJ.Silver
 * @fileName : BOJ_1141_접두사
 * @date : 2021. 12. 07.
 * @language : JAVA
 * @classification : math
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description
 **/
public class BOJ1141 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set  = new HashSet();

        //값 입력
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        String[] arr = set.toArray(new String[0]);
        int count = arr.length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if(i==j||arr[i].equals(arr[j]))continue;
                if(arr[j].startsWith(arr[i])){
                    count--;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
