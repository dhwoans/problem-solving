package exD5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Expert1256 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int K = Integer.parseInt(br.readLine());
            String str = br.readLine();
            ArrayList<String> arr = new ArrayList<>();
            for (int i = 0; i < str.length(); i++) {
                arr.add(str.substring(i,str.length()));
            }
            arr.sort((o1, o2) -> o1.compareTo(o2));
            System.out.println("#"+test_case+" "+arr.get(K-1));
        }
    }
}
