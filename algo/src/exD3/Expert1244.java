package exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Expert1244 {//풀이중
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int change = Integer.parseInt(st.nextToken());
            //배열 생성
            int[] arr = new int[num.length()];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Character.getNumericValue(num.charAt(i));
            }
            int z = 0;


            while (change != 0) {
                int max = 0;
                int pos = 0;

                for (int i = arr.length - 1; i >= z; i--) {
                    if (max < arr[i]) {
                        max = arr[i];
                        pos = i;
                    }
                }
                if (pos != z) {
                    int temp = arr[z];
                    arr[z] = arr[pos];
                    arr[pos] = temp;
                    change--;
                }
                if(z<arr.length-2){
                    z++;
                }else if(z==arr.length-2){
                    break;
                }


            }
            System.out.print("#" + test_case + " ");
            for (int i : arr) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
