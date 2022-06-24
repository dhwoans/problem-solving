package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ6479_kruskal {

    private static Integer[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int sum =0;
            int answer =0;
            if (m == 0 && n == 0) break;
            arr = new Integer[m];
            ArrayList<int[]> list = new ArrayList<>();
            make();
            //간선 from to cost
            for (int i = 0; i < n; i++) {
                int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                sum+=info[2];
                list.add(info);
            }
            //정렬
            list.sort((o1, o2) -> o1[2]-o2[2]);
            for (int[] ints : list) {
                if(find(ints[0])!=find(ints[1])){
                    union(ints[0],ints[1]);
                    answer += ints[2];
                }
            }


            System.out.println(sum-answer);
        }
    }

    private static int find(int node) {
        if(arr[node]==node) return node;
        else return find(arr[node]);
    }

    private static void union(int a, int b) {
        a= find(a);
        b= find(b);
        if(a>b) arr[a]=b;
        else arr[b]=a;

    }

    private static void make() {
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;
        }

    }
}
