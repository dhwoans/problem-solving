package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            TreeMap<Integer,Integer> map = new TreeMap();

            for (int j = 0; j < k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if (command == 'I') {
                    map.put(num,map.getOrDefault(num,0)+1);
                } else if (command == 'D') {
                    if (num == -1 &&!map.isEmpty()) {
                        if(map.get(map.firstKey())==1){
                            map.remove(map.firstKey());
                        }else {
                            map.put(map.firstKey(),map.get(map.firstKey())-1);
                        }
                        continue;
                    }
                    if (num == 1&&!map.isEmpty() ) {
                        if(map.get(map.lastKey())==1){
                            map.remove(map.lastKey());
                        }else {
                            map.put(map.lastKey(),map.get(map.lastKey())-1);
                        }
                        continue;
                    }
                }
            }
            if (map.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey());
            }
            System.out.println(sb);
        }
    }
}
