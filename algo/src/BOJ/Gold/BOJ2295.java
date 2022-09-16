package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class BOJ2295 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        HashSet<Integer> set = new HashSet<>();
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i]=Integer.parseInt(br.readLine());
        }
        for (int k : arr) {
            for (int i : arr) {
                set.add(i+k);
            }
        }
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int val = arr[j]-arr[i];
                if(val<=0)continue;
                if(set.contains(val)){
                    answer = Math.max(answer,arr[j]);
                }
            }
        }
        System.out.println(answer);

    }
}