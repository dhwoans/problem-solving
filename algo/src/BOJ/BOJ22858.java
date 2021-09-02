package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ22858 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] suffle = new int[size];
        int[] answer = new int[size];
        int[] temp= new int[size];
        st=new StringTokenizer(br.readLine());
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for (int i = 0; i < suffle.length; i++) {
            suffle[i]=Integer.parseInt(st.nextToken());
            answer[i]=i+1;

        }
        for (int j = 0; j < N; j++) {
            for (int i = 0; i < size; i++) {
                temp[i] = answer[suffle[i] - 1];
            }
            answer= Arrays.copyOf(temp,size);
        }
        for (int i = 0; i < result.length; i++) {
            answer[i]=result[temp[i]-1];
        }
        for (int i : answer) {
            System.out.print(i+" ");
        }

    }
}
