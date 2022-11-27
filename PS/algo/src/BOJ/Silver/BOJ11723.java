package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 11723.집합
 */
public class BOJ11723 {
    public static void main(String[] args) throws IOException {
        List<Integer> integers = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            integers.add(i);
        }
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command= st.nextToken();
            int num = 0;

            switch (command){
                case "add":
                    num=Integer.parseInt(st.nextToken());
                    set.add(num);
                    break;
                case "remove":
                    num=Integer.parseInt(st.nextToken());
                    set.remove(num);
                    break;
                case "check":
                    num=Integer.parseInt(st.nextToken());
                    if(set.contains(num)){
                        sb.append(1).append("\n");
                    }else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "toggle":
                    num=Integer.parseInt(st.nextToken());
                    if(set.contains(num)){
                        set.remove(num);
                    }else{
                        set.add(num);
                    }
                    break;
                case "all":
                    set.addAll(integers);
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
            System.out.println(sb);
    }
}
