package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1158 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(st.nextToken());
        int kill = Integer.parseInt(st.nextToken());

        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> arr = new LinkedList<>();

        for(int i=1;i<=size;i++){
            arr.offer(i);
        }


        while(!arr.isEmpty()){
            for(int n=0;n<kill-1;n++) {
                arr.offer(arr.poll());

            }

            answer.add(arr.poll());


        }

        sb.append("<");
        for(int j=0;j<answer.size()-1;j++){
            sb.append(answer.get(j) + ", " );
        }
        sb.append(answer.get(answer.size()-1));
        sb.append(">");
        System.out.println(sb.toString());
    }

}
