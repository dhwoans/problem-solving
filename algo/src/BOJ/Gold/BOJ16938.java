package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BOJ16938 {

    private static boolean[] visited;
    private static int[] condiction;
    private static int[] arr;
    private static int count;

    public static void main(String[] args) throws IOException {
        count = 0;
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        condiction = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[arr.length];

        powerSet(0,condiction[0]);
        System.out.println(count);
    }

    private static void powerSet(int cnt,int n) {
        if(cnt==n){
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if(visited[i])continue;
                temp.add(arr[i]);
            }
            pick(temp);
            return;
        }
        visited[cnt]=true;
        powerSet(cnt+1,n);
        visited[cnt]=false;
        powerSet(cnt+1,n);


    }

    private static void pick(List<Integer> arr) {
        if(arr.size()<1)return;
        int max = arr.stream().max((o1, o2) -> o1-o2).get();
        int min = arr.stream().min(((o1, o2) -> o1-o2)).get();
        if(max-min<condiction[3])return;
        int range =arr.stream().mapToInt(it -> it).sum();
        if(condiction[1]>range||condiction[2]<range)return;
        count++;
    }
}
