package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14427 {
    private static int[] arr;
    private static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        tree = new int[n * 4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }
        //세그먼트 트리 초기화
        init(1, arr.length - 1, 1);

        int query = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < query; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            if (command == 2) {
                sb.append(tree[1]).append("\n");
            } else if (command == 1) {
                int index = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[index] = v;
                update(1,arr.length-1,1,index);
            }
        }
        System.out.println(sb);


    }

    private static int update(int start, int end, int node, int index) {
        //범위 벗어남
        if (start > index || index > end) return tree[node];

        if (start == end) return tree[node]= index;

        int mid = (start + end) / 2;
        int left = update(start, mid, node*2, index);
        int right =  update(mid+1, end, node*2+1, index);
        return tree[node] = getmin(left,right);
    }

    private static int getmin(int x, int y) {
        if (arr[x] == arr[y]) return Math.min(x, y);
        else return arr[x]>arr[y]?y:x;

    }

    private static int init(int start, int end, int node) {
        if (start == end) return tree[node] = start;
        int mid = (start + end) / 2;
        return tree[node] = getmin(init(start, mid, node * 2), init(mid + 1, end, node * 2 + 1));
    }

}
