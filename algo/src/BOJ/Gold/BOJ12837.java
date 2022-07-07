package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12837 {

    private static long[] data;
    private static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        data = new long[n + 1];
        tree = new long[n * 4];

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());

            if(command == 1){
                int index = Integer.parseInt(st.nextToken());
                int money = Integer.parseInt(st.nextToken());
                data[index] += money;
                modify(1,n,1,index);
            }else if(command == 2){
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                System.out.println(query(1,n,1,left,right));
            }
        }
    }

    private static long query(int start,int end,int node,int left,int right) {
        if(start>right||left>end) return 0;
        if(start>=left&&right>=end)return tree[node];
        int mid = (start+end)/2;
        return query(start,mid,node*2,left,right)+query(mid+1,end,node*2+1,left,right);
    }

    private static long modify(int start,int end,int node,int index) {
        if(start>index||index>end) return tree[node];
        if(start==end)return tree[node]=data[index];
        int mid = (start + end)/2;
        return tree[node] = modify(start,mid,node*2,index)+
        modify(mid+1,end,node*2+1,index);
    }
}
