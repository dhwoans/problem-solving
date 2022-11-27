package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1038 {
    
    private static int[] arr ={0,1,2,3,4,5,6,7,8,9};
    private static int[] pick;
    private static ArrayList<Long> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        answer = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {

                pick = new int[i];
                make(0,i,10);
        }
        if(n<answer.size()) System.out.println(answer.get(n));
        else System.out.println(-1);
    }

    private static void make(int cnt,int target,int num) {
        if(cnt==target){
            String str="";
            for (int i : pick) {
               str+=i;
            }
            answer.add(Long.parseLong(str));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(num<=arr[i])continue;
            pick[cnt]=arr[i];
            make(cnt+1,target,arr[i]);
        }
    }
}
