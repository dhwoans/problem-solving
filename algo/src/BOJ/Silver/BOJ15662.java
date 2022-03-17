package BOJ.Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H =Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        //정보입력
        int[] map = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < map.length; i++) {
            map[i]=Integer.parseInt(st.nextToken());
        }

        Stack<int[]> stack = new Stack<>();
        stack.add(new int[]{0,map[0]});
        int count =0;
        for (int i = 1; i < map.length; i++) {
            if(stack.peek()[1]>=map[i]){
                count = Math.max(count,map[i]);
            }else if(stack.peek()[1]<map[i]){
                if(map[map.length-1]==0)continue;
                int[] temp =stack.pop();
                int val = Math.min(temp[1],count);
                stack.add(new int[]{temp[0],val});
                stack.add(new int[]{i,map[i]});
            }

        }
        if(stack.peek()[0]!=map.length-1){
            int[] temp =stack.pop();
            int val = Math.min(temp[1],map[map.length-1]);
            stack.add(new int[]{temp[0],val});

        }

        int result =0;
        for (int i = map.length-1; i >= 0; i--) {
            if(stack.peek()[0]>=i){
                stack.pop();
            }else{
                if(stack.peek()[1]-map[i]>0){
                    result+=stack.peek()[1]-map[i];
                }
            }
        }
        System.out.println(result);
    }
}
