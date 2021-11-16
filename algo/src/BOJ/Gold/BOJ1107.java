package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 1107.리모콘
 *
 *
 */
public class BOJ1107 {//풀이중
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        //0-9까지
        boolean[] key = new boolean[10];
        //목표
        int target = Integer.parseInt(br.readLine());
        //고장난  숫자
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < T; i++) {
            key[Integer.parseInt(st.nextToken())]=true;
        }
        //+-버튼으로만 눌려서 
        int answer = Math.abs(target - 100);
        //가까운 채널로 가서 +-

    }
}
