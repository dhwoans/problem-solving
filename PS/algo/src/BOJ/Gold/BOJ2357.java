package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2357 {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        int[] mintree = new int[n * 4];
        int[] maxtree = new int[n * 4];

        for (int i = 1; i < arr.length; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }

        init(mintree,1,n,1,"min");
        init(maxtree,1,n,1,"max");

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            arr[0]=Integer.MAX_VALUE;
            int min=sum(mintree,1,n,1,left,right,"min");
            System.out.print(arr[min]+" ");
            arr[0]=Integer.MIN_VALUE;
            int max=sum(maxtree,1,n,1,left,right,"max");
            System.out.println(arr[max]);

        }
    }

    private static int sum(int[] tree ,int start,int end,int node,int left,int right,String mode) {
        if(start>right||left>end)return 0;
        if(right>=end&&left<=start) return tree[node];

        int mid = (start + end )/2;
        if(mode.equals("min"))return getMin(sum(tree,start,mid,node*2,left,right,mode)
                ,sum(tree,mid+1,end,node*2+1,left,right,mode));

        else return getMax(sum(tree,start,mid,node*2,left,right,mode)
                ,sum(tree,mid+1,end,node*2+1,left,right,mode));
    }

    private static int init(int[] tree,int start,int end,int node,String mode) {
        if(start==end)return tree[node]=start;

        int mid = (start+end)/2;
        int left = init(tree,start,mid,node*2,mode);
        int right = init(tree,mid+1,end,node*2+1,mode);

        if(mode.equals("min")) return tree[node]= getMin(left, right);
        else return tree[node]= getMax(left, right);
    }

    private static int getMax(int x, int y) {
        if(arr[x]==arr[y])return Math.max(x,y);
        return arr[x]>arr[y]?x:y;
    }

    private static int getMin(int x, int y) {
        if(arr[x]==arr[y])return Math.min(x,y);
        else return arr[x]>arr[y]?y:x;
    }

}
