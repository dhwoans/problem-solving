package SWEA.exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class Expert4047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data =
                "3\n" +
                        "S01D02H03H04S10D10H10C01\n" +
                        "H02H10S11H02\n" +
                        "S10D10H10C01";
        br = new BufferedReader(new StringReader(data));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int[] S = new int[14];
            int[] D = new int[14];
            int[] H = new int[14];
            int[] C = new int[14];
            String str = br.readLine();
            for (int i = 0; i < str.length(); i += 3) {
                String card = str.substring(i, i + 3);
                switch (card.charAt(0)) {
                    case 'S':
                        if (card.charAt(1) == '0') {
                            S[Character.getNumericValue(card.charAt(2))]++;
                        } else {
                            S[Character.getNumericValue(card.charAt(2)) + 10]++;
                        }
                        break;
                    case 'D':
                        if (card.charAt(1) == '0') {
                            D[Character.getNumericValue(card.charAt(2))]++;
                        } else {
                            D[Character.getNumericValue(card.charAt(2)) + 10]++;
                        }
                        break;
                    case 'H':
                        if (card.charAt(1) == '0') {
                            H[Character.getNumericValue(card.charAt(2))]++;
                        } else {
                            H[Character.getNumericValue(card.charAt(2)) + 10]++;
                        }
                        break;
                    case 'C':
                        if (card.charAt(1) == '0') {
                            C[Character.getNumericValue(card.charAt(2))]++;
                        } else {
                            C[Character.getNumericValue(card.charAt(2)) + 10]++;
                        }
                        break;
                }


            }
            int count1 = 13;
            int count2 = 13;
            int count3 = 13;
            int count4 = 13;
            boolean flag=true;
            for (int i = 1; i < S.length; i++) {
                if (S[i] > 1 || H[i] > 1 || D[i] > 1 || C[i] > 1) {
                    System.out.println("#" + test_case + " ERROR");
                    flag=false;
                    break;
                }
                if (S[i] == 1) {
                    count1--;
                }
                if (D[i] == 1) {
                    count2--;
                }
                if (H[i] == 1) {
                    count3--;
                }
                if (C[i] == 1) {
                    count4--;
                }
            }
            if(flag)
            System.out.println("#"+test_case+" "+count1+" "+count2+" "+count3+" "+count4);

        }
    }
}
