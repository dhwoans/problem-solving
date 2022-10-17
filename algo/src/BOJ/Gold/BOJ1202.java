package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<int[]> jam = new PriorityQueue<>((o1, o2) ->{
                if(o1[0]==o2[0]) return o2[1]-o1[1];
                return o1[0]-o2[0];
        });
        PriorityQueue<Integer> back = new PriorityQueue<>((o1, o2) -> o2-o1);

        //보석정보
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            jam.add(new int[]{weight,cost});
        }
        //가방정보
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort((o1, o2) -> o1-o2);

        //가방-보석무게비교
        Long sum=0L;
        for (int i = 0; i < list.size(); i++) {
            int w = list.get(i);
            while(!jam.isEmpty()){
                if(w>=jam.peek()[0]){
                    back.add(jam.poll()[1]);
                }else break;
            }
            if(back.isEmpty()) continue;
            sum += back.poll();
        }
        System.out.println(sum);
    }
}
