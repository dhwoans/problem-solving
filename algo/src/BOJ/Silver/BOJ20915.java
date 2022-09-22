package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ20915 {

    private static Integer[] num;
    private static boolean[] visited;
    private static StringBuilder sb;
    private static Long answer1, answer2;
    private static Long min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            answer1 =0L;
            answer2 =0L;
            min = 0L;
            String str = br.readLine();
            num = new Integer[str.length()];

            for (int j = 0; j < str.length(); j++) {
                num[j] = str.charAt(j) - '0' == 6 ? 9 : str.charAt(j) - '0';
            }

            Arrays.sort(num, Collections.reverseOrder());
            StringBuilder temp1 = new StringBuilder();
            StringBuilder temp2 = new StringBuilder();
            temp1.append(num[0]);
            temp2.append(num[1]);
            for (int j = 2; j < num.length; j++) {
                if(Integer.parseInt(temp1.toString())>Integer.parseInt(temp2.toString())){
                    temp2.append(num[j]);
                }else{
                    temp1.append(num[j]);
                }
            }
            sb.append(Long.parseLong(temp1.toString()) * Long.parseLong(temp2.toString())).append("\n");

//            visited = new boolean[num.length];
//            dfs(0,0);
//            sb.append(answer1*answer2).append("\n");
        }
        System.out.println(sb);
    }
//    private static void dfs(int cnt, int start){
//        if (cnt == num.length / 2) {
//            cal();
//            return;
//        }
//        for (int i = start; i < num.length; i++) {
//            if(visited[i])continue;
//            visited[i]=true;
//            dfs(cnt+1,i+1);
//            visited[i]=false;
//        }
//    }
//    private static void cal(){
//
//        StringBuilder num1 = new StringBuilder();
//        StringBuilder num2 = new StringBuilder();
//
//        for (int i = 0; i < visited.length; i++) {
//            if(visited[i])num1.append(num[i]);
//            else num2.append(num[i]);
//        }
//
//        long l = Long.parseLong(num1.toString()) * Long.parseLong(num2.toString());
//        if(min <l){
//            min = l;
//            answer1 = Long.parseLong(num1.toString());
//            answer2 = Long.parseLong(num2.toString());
//        }
//
//    }

}