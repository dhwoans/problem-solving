package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class BOJ6068 {
    private static class job{
        int t;
        int end;

        private job(int t,int end){
            this.t = t;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        ArrayList<job> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr.add(new job(t,end));
        }
        //정렬
        arr.sort(Comparator.comparing(job -> job.end));
        var time = arr.get(0).end-arr.get(0).t;
        if(time<0){
            System.out.println(-1);
            return;
        }

        var start = arr.get(0).end;
        for (int i = 1; i < arr.size(); i++) {
            start+=arr.get(i).t;
           if(start>arr.get(i).end) {
               if(time<abs(arr.get(i).end-start)){
                   System.out.println(-1);
               }else{
                   time-=abs(arr.get(i).end-start);
                   start-=abs(arr.get(i).end-start);
               }
           }
        }
        System.out.println(time);

    }
}
