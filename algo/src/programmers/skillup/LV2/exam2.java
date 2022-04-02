package programmers.skillup.LV2;


import java.util.HashMap;
import java.util.Map;

public class exam2 {

    private static boolean[] booleans;
    private static char[] arr;
    private static int count;
    private static int[] pick;
    private static Map<Integer, Boolean> map;

    public static int solution(String numbers) {
        count = 0;
        arr = numbers.toCharArray();
        map = new HashMap<>();
        booleans = new boolean[arr.length];
        for (int i = 1; i <= arr.length; i++) {
            pick = new int[i];
            dfs(0,0,i);
        }

        return count;
    }

    private static void dfs(int cnt,int start,int end) {
        if(cnt==end){
            cal();
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(booleans[i])continue;
            booleans[i]=true;
            pick[cnt]= arr[i]-'0';
            dfs(cnt+1,i,end);
            booleans[i]=false;
            
        }
    }

    private static void cal() {

        String str ="";
        boolean flag =false;
        for (int i = 0; i < pick.length; i++) {
            str+=pick[i];

        }
        int val = Integer.parseInt(str);
        if(map.containsKey(val)){
            return;
        }else{
            map.put(val,true);
        }
        System.out.println(val);
        if(val==0||val==1)return;
        for (int i = 2; i < val; i++) {
            if(val%i==0) {
                return;
            }
        }
        count++;
    }

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }
}