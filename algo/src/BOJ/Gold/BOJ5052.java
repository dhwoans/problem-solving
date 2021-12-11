package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            boolean flag =true;
            String[] arr = new String[num];
            for (int j = 0; j < num; j++) {
                arr[j]=br.readLine();
            }
            Arrays.sort(arr);
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j + 1].startsWith(arr[j])) {
                    System.out.println("NO");
                    flag = false;
                    break;
                }
            }

            if(flag){
                System.out.println("YES");
            }

        }
    }
}
