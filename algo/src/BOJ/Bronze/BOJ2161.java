package BOJ.Bronze;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ2161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        Queue<Integer> que = new LinkedList<>();
        for(int i=1;i<=n;i++){
            que.offer(i);
        }

        Queue<Integer> tresh = new LinkedList<>();
        while (!que.isEmpty()){
            tresh.offer(que.peek());
            que.poll();
            que.offer(que.peek());
            que.poll();
        }
        for(int x:tresh){
            System.out.print(x+" ");
        }
    }
}
