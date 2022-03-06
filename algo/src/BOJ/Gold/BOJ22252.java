package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ22252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        long result = 0;
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                String name = st.nextToken();
                PriorityQueue<Integer> temp = new PriorityQueue<>((o1, o2) -> o2-o1);
                if(map.containsKey(name)){
                    temp = map.get(name);
                }
                int unit = Integer.parseInt(st.nextToken());

                for (int j = 0; j < unit; j++) {
                    temp.add(Integer.parseInt(st.nextToken()));
                }
                map.put(name,temp);
            }else if(num ==2){
                String name  =st.nextToken();
                int unit = Integer.parseInt(st.nextToken());
                if(map.containsKey(name)){
                    for (int j = 0; j < unit; j++) {
                        if(map.get(name).isEmpty())break;
                        result += map.get(name).poll();
                    }
                }
            }
        }
        System.out.println(result);
    }
}
