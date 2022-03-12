package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BOJ3190 {
    private static class xy {
        int x;
        int y;

        private xy(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class command {
        int second;
        char dir;

        private command(int second, char dir) {
            this.second = second;
            this.dir = dir;
        }
    }

    //뱀
    private static class snake {
        int len = 1;
        int dir = 3;
        xy pos;
        List<xy> body;

        private snake() {
            this.pos = new xy(0, 0);
            this.body = new ArrayList<xy>();
            body.add(new xy(0, 0));
        }

        private void eat() {
            len += 1;
        }

        private void go() {
            if (this.dir == 0) {
                this.pos.x -= 1;
            } else if (this.dir == 1) {
                this.pos.x += 1;
            } else if (this.dir == 2) {
                this.pos.y -= 1;
            } else if (this.dir == 3) {
                this.pos.y += 1;
            }
        }

        //방향전환
        private void changeDir(char c) {
            if (this.dir == 0) {
                if (c == 'L') dir = 2;
                else dir = 3;
            } else if (dir == 1) {
                if (c == 'L') dir = 3;
                else dir = 2;
            } else if (dir == 2) {
                if (c == 'L') dir = 1;
                else dir = 0;
            } else {
                if (c == 'L') dir = 0;
                else dir = 1;
            }
        }

        // 몸통 체크
        private void bodycheck() {
            if (body.size() != len) {
                body.remove(0);
            }
        }

        // 충돌 체크
        private boolean crush() {
            for (BOJ3190.xy z : body) {
                if (pos.x == z.x && pos.y == z.y) {
                    return true;
                }

            }
            body.add(new xy(pos.x, pos.y));
            return false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];


        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x - 1][y - 1] = 1;
        }

        int com = Integer.parseInt(br.readLine());
        Queue<command> commands = new LinkedList<>();

        for (int i = 0; i < com; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);

            commands.add(new command(s + 1, c));
        }
        int turn = 1;
        snake s = new snake();
        while (true) {
            //머리 다음 칸에 위치
            s.go();
            if (s.pos.x < 0 || s.pos.y < 0 || s.pos.x >= n || s.pos.y >= n) {
                break;
            }
            if (s.crush()) {
                break;
            }

            //이동한 칸에 사과 있는지 확인
            if (map[s.pos.x][s.pos.y] == 1) {
                s.eat();
                map[s.pos.x][s.pos.y] = 0;
            }

            //몸통체크
            s.bodycheck();

            //턴증가
            turn++;

            //방향전환
            if (commands.isEmpty()) continue;
            if (turn == commands.peek().second) {
                s.changeDir(commands.peek().dir);
                commands.poll();
            }
        }
        System.out.println(turn);
    }
}

