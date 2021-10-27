package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 3190.뱀
 * <p>
 * 사과의 위치는 모두 다르며, 맨 위 맨 좌측 (1행 1열) 에는 사과가 없다.
 * X는 10,000 이하의 양의 정수이며, 방향 전환 정보는 X가 증가하는 순으로 주어진다.
 */
public class BOJ3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());//맵크기
        int K = Integer.parseInt(br.readLine());//사과개수
        StringTokenizer st;

        //맵정보 입력
        int[][] map = new int[N+2][N+2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());//행
            int x = Integer.parseInt(st.nextToken());//열

            //사과는 2로 표시
            map[y][x] = 2;
        }

        //명령 저장
        Queue<String[]> com = new LinkedList<>();
        int command = Integer.parseInt(br.readLine());
        for (int i = 0; i < command; i++) {
            st = new StringTokenizer(br.readLine());
            //시간
            String sc = st.nextToken();
            //방향
            String dir = st.nextToken();

            com.offer(new String[]{sc, dir});

        }
        //시작
        int turn = 0;
            snake s = new snake();
        while (true) {
            turn++;
            //명령확인
            if (!com.isEmpty()&&Integer.parseInt(com.peek()[0]) == turn) {
                s.dir(com.poll()[1]);
            }
            //한칸앞으로
            s.go();
            if (s.x == 0 || s.y == 0 || s.x == map.length-1 || s.y == map.length-1) {

                break;
            }
            //시과를 만나면 먹는다
            if (map[s.x][s.y] == 2) {
                s.eat();
            }

            s.status();

            //충돌확인
            //벽에 부딪힘
            if (s.check()) {
                break;
            }
        }
        System.out.println(turn+1);

    }
}

class snake {
    int x;
    int y;
    int len;
    List<int[]> que;
    int head;

    public snake() {
        x = 1;
        y = 1;
        len = 1;
        que = new ArrayList<int[]>();
        head = 2;
    }

    /**
     * 이동하기
     */
    public void go() {
        que.add(new int[]{x, y});
        int deltas[][] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};//0상,1하,2좌,3우
        x += deltas[head][0];
        y += deltas[head][1];
        que.add(new int[]{x, y});
    }
    //L==왼쪽 D==오른쪽

    /**
     * 방향 전환하기
     *
     * @param dir
     */
    public void dir(String dir) {


        switch (head) {
            case 0:
                if (dir.equals("L")) {
                    head = 3;
                } else {
                    head = 2;
                }
                break;
            case 1:
                if (dir.equals("L")) {
                    head = 2;
                } else {
                    head = 3;
                }
                break;
            case 2:
                if (dir.equals("L")) {
                    head = 0;
                } else {
                    head = 1;
                }
                break;
            case 3:
                if (dir.equals("L")) {
                    head = 1;
                } else {
                    head = 0;
                }
                break;
        }
    }

    /**
     * 몸 길이 늘리기
     */
    public void eat() {

        len++;
    }

    /**
     * 현재위치 확인하기
     */
    public void status() {
        if (que.size() > len) {
            while (que.size() != len) {
                que.remove(0);
            }
        }
    }

    /**
     * 배열로 담으면 set으로 중복체크를 못한다.
     * 충돌 확인하기
     * @return
     */
    public boolean check() {
        boolean flag = false;
        //뱀길이가 3이하면 부딫힐 일이 없다
        int arr = que.get(0)[0];
        return flag;
    }
}
