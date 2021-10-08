package SWEA.exD3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert4698 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            boolean[] arr = new boolean[1000001];
            arr[0] = true;
            arr[1] = true;
            int count = 0;
            for (int i = 2; i < 1000000; i++) {
                if(arr[i])continue;
                for (int j = 2; j < 500000; j++) {
                    if (i * j > 1000000) break;
                    arr[i * j] = true;
                }
            }

                StringTokenizer st = new StringTokenizer(br.readLine());
                String D = st.nextToken();
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());


                for (int z = A; z <= B; z++) {
                    if (!arr[z] && Integer.toString(z).contains(D)) {
                        count++;
                    }
                }

                System.out.println("#" + test_case + " " + count);
        }
    }
}


