package SWEA.exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Expert5549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            String n = br.readLine();
            System.out.printf("#%d ",test_case);
            if(Character.getNumericValue(n.charAt(n.length()-1))%2==0){
                System.out.println("Even");

            }else{
                System.out.println("Odd");
            }
        }

    }
}
