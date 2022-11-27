package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14428 {

    private static int[] data;
    private static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        data = new int[n + 1];
        tree = new int[n * 4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < data.length; i++) {
            data[i]=Integer.parseInt(st.nextToken());
        }
        //tree 초기화
        init(1,n,1);
        data[0]=Integer.MAX_VALUE;
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if(command==1){//수정
                int index = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                data[index]=value;
                update(1,n,1,index);
            }else if(command==2){
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                System.out.println(sum(1,n,1,left,right));
            }
        }

    }

    private static int sum(int start ,int end, int node, int left,int right) {
        //범위에서 벗어남
        if(left>end || right<start )return 0;
        if(right>=end&&left<=start) return tree[node];

        int mid = (start+end)/2;
        return getmin(sum(start,mid,node*2,left,right),sum(mid+1,end,node*2+1,left,right));
    }

    private static int update(int start,int end,int node,int index) {
        //범위에 벗어남
        if(start>index||index>end)return tree[node];
        if(start==end)return tree[node]= index;

        int mid=(start+end)/2;
        int left = update(start,mid,node*2,index);
        int right = update(mid+1,end,node*2+1,index);
        return tree[node]=getmin(left,right);
    }

    private static int init(int start,int end,int node) {
        if(start==end)return tree[node]= start;
        int mid = (start + end)/2;
        return tree[node]= getmin(init(start,mid,node*2),init(mid+1,end,node*2+1));
    }

    private static int getmin(int x,int y) {
        if(data[x]==data[y])return Math.min(x,y);
        return data[x]>data[y]?y:x;
    }
}
