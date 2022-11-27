package BOJ.Gold;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ2212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine())-1;
        int[] arr = new int[n];
        int[] partition  = new int[n-1];
        int answer= 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < partition.length; i++) {
            partition[i]=Math.abs(arr[i]-arr[i+1]);
        }

        Arrays.sort(partition);

        for (int i = 0; i < partition.length-k; i++) {
            answer+=partition[i];
        }

        System.out.println(answer);
    }
}
