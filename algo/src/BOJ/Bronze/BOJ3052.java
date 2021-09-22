package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int[] ints = new int[42];
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            ints[n%42]++;
        }
        int count = 0;
        for (int anInt : ints) {
            if(anInt>0){
                count++;
            }
        }
        System.out.println(count);
    }
}
