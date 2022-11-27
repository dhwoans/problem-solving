package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17609 {

    private static boolean pseudo;
    private static boolean normal;
    private static String str;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            str = br.readLine();
            int start = 0;
            int end = str.length()-1;
            int answer = check(start, end,false);
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    private static int check(int start, int end,boolean flag) {
        if(start>end){
            if(flag){
                return 1;
            }else {
               return 0;
            }
        }
        if(str.charAt(start)!=str.charAt(end)) {
            if(!flag){
               int result= check(start+1,end,true);
               if(result==2) result =check(start,end-1,true);
               return result;
            }else{
                return 2;
            }
        }
        return check(start+1,end-1,flag);
    }
}
