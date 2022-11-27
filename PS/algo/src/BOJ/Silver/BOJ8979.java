package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ8979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<nation> que = new PriorityQueue<>((o1, o2) -> {
            if (o2.gold == o1.gold) {
                if (o2.silver == o1.silver) {
                    return o2.bronze - o1.bronze;
                }
                return o2.silver - o1.silver;
            }
            return o2.gold - o1.gold;
        });

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            que.add(new nation(no, gold, silver, bronze));
        }
        int rank =1;
        int same =0;
        while (!que.isEmpty()) {
            nation nation = que.poll();
            if(nation.no==k){
                System.out.println(rank);
                return;
            }
            if(que.peek().gold==nation.gold&&
                    que.peek().silver==nation.silver&&
                    que.peek().bronze==nation.bronze){
                same++;
            }else{
                rank+=same+1;
                same=0;
            }
        }
    }

    private static class nation {
        private int no;
        private int gold;
        private int silver;
        private int bronze;

        private nation(int no, int gold, int silver, int bronze) {
            this.no = no;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

    }

}
