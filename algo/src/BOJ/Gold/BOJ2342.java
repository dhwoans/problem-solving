package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> order = new ArrayList<>();

        while (true){
            int num = Integer.parseInt(st.nextToken());
            if(num==0)break;
            order.add(num);
        }
        
        int result = bfs(order);
        System.out.println(result);

    }

    private static int bfs(ArrayList<Integer> order) {
        int left =0;
        int right =right=order.get(0);
        int amount =2;
        for (int i = 1; i < order.size(); i++) {
            int R =energy(right, order.get(i));
            int L =energy(left, order.get(i));
            if(R>=L){
                amount+=L;
                left=order.get(i);
            }else{
                amount+=R;
                right=order.get(i);
            }
        }
        return amount;
    }

    private static int energy(int foot, int i) {
        int plus =foot+1;
        int minus = foot-1;
        if(plus==5)plus=1;
        if(minus==0)minus=4;

        if(foot==i)return 1;
        else if(foot==0)return 2;
        else if(plus==i||minus==i)return 3;
        else return 4;
    }
}
