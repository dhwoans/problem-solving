package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BOJ2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int[] firstAlphabet = new int[26];
        String firstWord = br.readLine();

        //처음 단어 알바벳 저장
        for (int i = 0; i < firstWord.length(); i++) {
            firstAlphabet[firstWord.charAt(i) - 'A']++;
        }

        for (int i = 0; i < n - 1; i++) {
            int[] nextAlphabet = new int[26];
            String nextWord = br.readLine();
            //다음 단어 알바벳 저장
            for (int j = 0; j < nextWord.length(); j++) {
                nextAlphabet[nextWord.charAt(j) - 'A']++;
            }

            int plus = 0;
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                int gap = Math.abs(nextAlphabet[j] - firstAlphabet[j]);

                if (gap > 1) break;
                else if (gap == 1) plus++;

                if (j == 25) {
                    if (plus < 2 || (plus == 2 && nextWord.length() == firstWord.length())) {
                        count++;
                    }
                }
            }

        }
        System.out.println(count);
    }
}
