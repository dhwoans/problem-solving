package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer[]> arr = new ArrayList<>();
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.add(new Integer[]{start,end});
        }
        //시작시간 정렬
        arr.sort((o1,o2)->{
            if(o1[0]==o2[0]){
                return  o1[1]-o2[1];
            }
            return o1[0]-o2[0];});

        for (int i = 0; i < arr.size(); i++) {
            Integer[] temp = arr.get(i);
            que.add(temp[1]);
            if(!que.isEmpty()&&que.peek()<=temp[0])que.poll();

        }
        System.out.println(que.size());

    }
}
