package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 3190.뱀
 *
 * 사과의 위치는 모두 다르며, 맨 위 맨 좌측 (1행 1열) 에는 사과가 없다.
 * X는 10,000 이하의 양의 정수이며, 방향 전환 정보는 X가 증가하는 순으로 주어진다.
 */
public class BOJ3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());//맵크기
        int K = Integer.parseInt(br.readLine());//사과개수
        StringTokenizer st;

        int[][] map = new int[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y=Integer.parseInt(st.nextToken());//행
            int x=Integer.parseInt(st.nextToken());//열

           map[x-1][y-1]=2;
        }
        Queue<String[]> com = new LinkedList<>();
        int command = Integer.parseInt(br.readLine());
        for (int i = 0; i < command; i++) {
            st = new StringTokenizer(br.readLine());
            String sc = st.nextToken();
            String dir = st.nextToken();

            com.offer(new String[]{sc,dir});

        }
        //시작
        int turn = 0;
        while(true){
        turn++;
        }

    }
}
class snake{
    int x;
    int y;
    int len;
    Queue que;
    public snake() {
        x=0;
        y=0;
        len=1;
        que=new LinkedList<Integer[]>();
    }
    //L==왼쪽 D==오른쪽
    public void dir(String dir){

    }

    public void eat(){
        len++;
    }
    
}
