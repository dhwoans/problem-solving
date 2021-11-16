package BOJ.Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1063.킹
 *
 * 열 index 다른거 주의
 */
public class BOJ1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String dol = st.nextToken();
        int command = Integer.parseInt(st.nextToken());

        //
        for (int i = 0; i < command; i++) {
            String dir = br.readLine();
            //대각선일때
            if(dir.length()>1){
                String ch = Character.toString(dir.charAt(0));
                dir = Character.toString(dir.charAt(1));
                pos(ch,king);
            }
                pos(dir,king);

        }

    }

    private static void pos(String ch,String str) {
        switch (ch){
            case "R":

                break;
            case "L":
                break;
            case "B":
                break;
            case "T":
                break;

        }
        //위
        //아래
        //왼
        //좌
    }

}
