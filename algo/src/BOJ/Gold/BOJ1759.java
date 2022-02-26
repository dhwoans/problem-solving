package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1759 {

    private static int[] arr;
    private static Integer[] input;
    private static int c;
    private static int l;
    private static boolean[] visit;
    private static HashMap<Integer, Integer> map;
    private static HashMap<Integer, Integer> hash;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[c];
        visit = new boolean[c];
        input = new Integer[l];

        map = new HashMap<>();
        hash = new HashMap<>();


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <arr.length ; i++) {
            arr[i]=st.nextToken().charAt(0);
            if(arr[i]=='a'-0||arr[i]=='e'-0||arr[i]=='i'-0||arr[i]=='o'-0||arr[i]=='u'-0){
                int temp = arr[i];
                map.put(temp,1);
            }else {
                int temp = arr[i];
                hash.put(temp,1);
            }
        }
        Arrays.sort(arr);
        dfs(0,0);

    }

    private static void dfs(int cnt,int num) {
        if(cnt==l){
            int j=0;
            int z=0;
            for (int i : input) {
              if(map.containsKey(i)){
                  j++;
              }else if(hash.containsKey(i)){
                  z++;
              }
            }
            if(j>=1&&z>=2){
                for (int i : input) {
                    System.out.print((char)i);
                }
                System.out.println();
            }
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(visit[i]||num>arr[i])continue;
            visit[i]=true;
            input[cnt]=arr[i];
            dfs(cnt+1,arr[i]);
            visit[i]=false;
        }
    }
}
