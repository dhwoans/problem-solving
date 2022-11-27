package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ10216 {

    private static ArrayList<info> infos;
    private static int[] root;

    private static class info{
        int x;
        int y;
        int dis;

        public info(int x,int y,int dis){
            this.x= x;
            this.y= y;
            this.dis= dis;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            make(n);
            infos = new ArrayList<>();
            //좌표 거리 정보
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int dis = Integer.parseInt(st.nextToken());
                infos.add(new info(x,y,dis));
            }
            //그루핑
            int ans=group(n);
            sb.append(ans).append("\n");


        }
        System.out.println(sb);
    }

    private static void make(int n) {
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i]=i;
        }
    }

    private static int group(int ans) {
        for (int i = 0; i < infos.size(); i++) {
            for (int j = i+1; j < infos.size(); j++) {

                int x1 = infos.get(i).x;
                int x2 = infos.get(j).x;
                int y1 = infos.get(i).y;
                int y2 = infos.get(j).y;
                int dis1 = infos.get(i).dis;
                int dis2 = infos.get(j).dis;
                //좌표 거리 dis 비교

                if((dis1+dis2)*(dis1+dis2)>=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2)){
                    if(find(i)!=find(j)){
                        union(i,j);
                        ans--;
                    }

                }
            }
        }
        return ans;
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a!=b){
            if(a<b) root[b]=a;
            else root[a]=b;
        }
    }

    private static int find(int i) {
        if(root[i]==i){
            return i;
        }

        return root[i] = find(root[i]);

    }
}
