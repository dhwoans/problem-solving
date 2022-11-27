package SWEA.exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Expert4676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String str =br.readLine();
            ArrayList<Character> ch = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                ch.add(str.charAt(i));
            }
            int H = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < H; i++) {
                int pos = Integer.parseInt(st.nextToken());
                ch.add(pos+i,'-');
            }
            System.out.print("#"+test_case+" ");
            for (Character c : ch) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
