package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ6986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        PriorityQueue<Double> que = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            que.add(Double.parseDouble(br.readLine()));
        }
        int count =0;
        double sum = 0;
        double first = 0;
        double end =0;

        while(!que.isEmpty()){
            count++;
            double val = que.poll();
            if(count>k&&count<=n-k){
                if(sum==0)first = val;
                sum +=val;
                end = val;
            }

        }
        System.out.printf("%.2f%n",sum/(n-2*k));
        System.out.printf("%.2f%n",(sum+first*k+end*k)/(n));
    }
}
