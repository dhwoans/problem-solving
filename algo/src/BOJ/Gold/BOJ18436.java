package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ18436 {

    private static int[] tree;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        tree = new int[n * 4];

        //배열 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        //트리 초기화
        init(1,n,1);

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if(command == 1){ //수정
                int index = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());
                int diff = arr[index];
                arr[index]=value;
                //홀 > 짝
                if(diff%2!=0&&value%2==0)update(1,n,1,index,-1);
                //짝 > 홀
                else if(diff%2==0&&value%2!=0)update(1,n,1,index,1);
            }else {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                int odd = sum(1,n,1,left,right);
                //짝수
                if(command == 2) System.out.println((right-left+1)-odd);
                //홀수
                else if(command ==3) System.out.println(odd);
            }
        }


    }

    private static int sum(int start,int end,int node,int left,int right) {
        if(start>right||left>end)return 0;
        if(start>=left&&right>=end)return tree[node];
        int mid = (start + end )/2;
        int l = sum(start,mid,node*2,left,right);
        int r = sum(mid+1,end,node*2+1,left,right);
        return l+r;
    }

    private static int update(int start,int end, int node, int index,int val) {
        if(start>index||index>end) return tree[node];
        if(start==end)return tree[node]+=val;
        int mid = (start + end)/2;

        return tree[node]=update(start,mid,node*2,index,val)+update(mid+1,end,node*2+1 ,index,val);
    }

    private static int init(int start , int end, int node) {
        if(start == end)return tree[node]=arr[start]%2==0?0:1;
        int mid = (start + end )/2;
        return tree[node]=init(start,mid,node*2)+init(mid+1,end,node*2+1);
    }
}
