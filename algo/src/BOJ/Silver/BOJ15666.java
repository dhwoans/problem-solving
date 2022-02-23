package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ15666 {

    private static int n;
    private static int m;
    private static int[] arr;
    private static int[] pick;
    private static ArrayList<int[]> result;
    private static HashMap<String, Boolean> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        pick = new int[m];
        result = new ArrayList<>();
        map = new HashMap<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i]= Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        //정렬
        Collections.sort(result,(o1, o2)->{
            for (int i = 0; i < o1.length; i++) {
                if(o1[i]==o2[i])continue;
                else return o1[i]-o2[i];
            }
            return o1[0]-o2[0];
        });
        for (int[] i : result) {
            for (int i1 : i) {
                System.out.print(i1+" ");
            }
            System.out.println();
        }

    }

    private static void dfs(int cnt ,int num) {
        if(cnt==m){
            cal(pick);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(num>arr[i])continue;
            pick[cnt]=arr[i];
            dfs(cnt+1,arr[i]);

        }
    }

    private static void cal(int[] pick) {
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for (int i : pick) {
            sb.append(i).append(" ");
        }

        if(map.getOrDefault(sb.toString(),false)){
            return;
        }else{
            map.put(sb.toString(),true);
            result.add(Arrays.copyOf(pick,pick.length));
        }
    }
}
