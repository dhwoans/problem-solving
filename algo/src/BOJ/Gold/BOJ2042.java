package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2042 {

    private static long[] tree;
    private static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        arr = new long[(int)(n + 1)];
        tree = new long[(int)(n * 4)];

        // 배열 입력
        for (int i = 1; i < n+1; i++) {
            arr[i]=Long.parseLong(br.readLine());
        }
        //트리 초기화
        init(1, n,1);

        for (int i = 0; i < m+k; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if(command==1){ //수정
                long index = Integer.parseInt(st.nextToken());
                long value = Long.parseLong(st.nextToken());
                long diff = value-arr[(int) index];
                arr[(int)index]=value;
                update(1,n,1,index,diff);
            }else if(command==2){
                long left  = Long.parseLong(st.nextToken());
                long right = Long.parseLong(st.nextToken());

                System.out.println(sum(1,n,1,left,right));
            }
        }
    }

    private static long sum(long start,long end,long node,long left,long right) {
        //범위 벗어남
        if(start>right||left>end)return 0;
        if(left<=start&&right>=end)return tree[(int) node];
        int mid = (int) ((start+end)/2);
        return sum(start,mid,node*2,left,right)+sum(mid+1,end,node*2+1,left,right);

    }

    private static long init(long start , long end,long node) {
        if(start==end)return tree[(int) node]= arr[(int) start];
        int mid = (int) ((start + end)/2);
        return tree[(int) node] = init(start,mid,node*2)+init(mid+1,end,node*2+1);
    }

    private static void update(long start , long end ,long node ,long index, long value) {
        if (index < start || index > end)return;

        tree[(int)node]+=value;

        if(start==end)return;
        int mid = (int) ((start+end)/2);
        update(start,mid,node*2,index,value);
        update(mid+1,end,node*2+1,index,value);

    }

}
