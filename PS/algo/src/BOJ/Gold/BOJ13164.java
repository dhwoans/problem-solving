package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer[] arr = new Integer[n];
        st = new StringTokenizer(br.readLine());
        //키 정보 담기
        for (int i = 0; i < n; i++) {
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Integer[] list = new Integer[n-1];

        for (int i = 0; i < arr.length-1; i++) {
            list[i]=arr[i+1]-arr[i];
        }
        Arrays.sort(list, Comparator.reverseOrder());
        int val = Arrays.stream(list,k-1,list.length).reduce(0, Integer::sum);
        System.out.println(val);
    }
}
