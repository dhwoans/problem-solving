package JO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Jo1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int sum = 0;
        int count = 0;
        int errR = 0;
        int errC = 0;
        boolean flag= true;
        for (int r = 0; r < map.length; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < map.length; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                sum += map[r][c];

            }
            if (sum == 0 || sum % 2 == 0) continue;
            count++;
            if (count == 2) {
                System.out.println("Corrupt");
                flag=false;
                break;
            } else {
                errR = r+1;

            }

            sum = 0;
        }
        count = 0;
        if (flag) {
            for (int c = 0; c < map.length; c++) {
                for (int r = 0; r < map.length; r++) {
                    sum += map[r][c];
                }
                if (sum == 0 || sum % 2 == 0) continue;
                count++;
                if (count == 2) {
                    System.out.println("Corrupt");
                    flag= false;
                    break;
                } else {
                    errC = c+1;

                }
                sum = 0;

            }
        }
        if (flag) {
            if (errR > 0 && errC > 0) {
                System.out.printf("Change bit (%d,%d)", errR, errC);
            } else {
                System.out.println("OK");
            }
        }
    }
}
