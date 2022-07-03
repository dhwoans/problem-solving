package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ2696 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int count = 0;
            ArrayList<Integer> list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            ArrayList<Integer> arr = new ArrayList<>();
            int repeat = n%10==0?n/10:n/10+1;
            for (int j = 0; j < repeat; j++) {
                String str= br.readLine();
                StringTokenizer st = new StringTokenizer(str);
                while(st.hasMoreTokens()){
                    arr.add(Integer.parseInt(st.nextToken()));
                }
            }

            PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> o1 - o2);
            PriorityQueue<Integer> reverse = new PriorityQueue<>((o1, o2) -> o2 - o1);

            for (int j = 0; j < arr.size(); j++) {

                if(que.size()==reverse.size())reverse.add(arr.get(j));
                else que.add(arr.get(j));

                if(!que.isEmpty()&&!reverse.isEmpty()){
                    if(que.peek()<reverse.peek()){
                        int temp = que.poll();
                        que.add(reverse.poll());
                        reverse.add(temp);
                    }
                }
                if((j+1)%2!=0){
                    count++;
                    list.add(reverse.peek());
                }
            }
            System.out.println(count);
            for (int j = 1; j < list.size()+1; j++) {
                System.out.print(list.get(j-1)+" ");
                if(j%10==0) System.out.println();
            }
            System.out.println();
        }

    }
}
