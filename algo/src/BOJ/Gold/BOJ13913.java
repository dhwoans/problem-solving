package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ13913 {

    private static int[] arr;
    private static int n;
    private static int k;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[100_001];
        visited = new int[100_001];
        Arrays.fill(visited,-1);
        bfs();
    }

    private static void bfs() {
        Queue<Integer[]> que = new LinkedList<>();
        que.add(new Integer[]{n,0});
        while(!que.isEmpty()){
            Integer[] temp = que.poll();

            if(temp[0] == k){
                tracking(temp[1]);
                return;
            }
            if(temp[0]+1 < visited.length && visited[temp[0]+1]==-1){
                visited[temp[0]+1]=temp[0];
                que.add(new Integer[]{temp[0]+1,temp[1]+1});
            }
            if(temp[0] -1 >= 0 &&visited[temp[0]-1]==-1){
                visited[temp[0]-1]=temp[0];
                que.add(new Integer[]{temp[0]-1,temp[1]+1});
            }
            if(temp[0] *2 < visited.length && visited[temp[0]*2]==-1){
                visited[temp[0]*2]=temp[0];
                que.add(new Integer[]{temp[0]*2,temp[1]+1});
            }
        }
    }

    private static void tracking(int count) {
        Stack<Integer> stack = new Stack<>();
        int  num = k;
        while (num != n) {
            stack.add(num);
            num=visited[num];
        }
        stack.add(n);

        System.out.println(count);
        //역추적
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
    }
}
