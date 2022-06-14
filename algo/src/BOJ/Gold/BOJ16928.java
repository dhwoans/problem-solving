package BOJ.Gold;

import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16928 {
    private static class info {
        int pos;
        int turn;

        info(int pos, int turn) {
            this.pos = pos;
            this.turn = turn;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] visited = new int[102];
        Arrays.fill(visited, Integer.MAX_VALUE);
        int answer = Integer.MAX_VALUE;
        HashMap<Integer, Integer> snake = new HashMap<>();
        HashMap<Integer, Integer> ladder = new HashMap<>();

        //사다리 수
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            snake.put(from, to);
        }

        //뱀 수
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            ladder.put(from, to);
        }
        Queue<info> que = new LinkedList();
        que.add(new info(1, 0));

        while (!que.isEmpty()) {
            info temp = que.poll();


            for (int i = 1; i <= 6; i++) {
                int next = temp.pos + i;
                if (next >= 100) {
//                answer = Math.min(answer, temp.turn);
//                System.out.println(answer);
                    System.out.println(temp.turn + 1);
                    return;
                }
                if (snake.containsKey(next) && visited[next] > temp.turn+1) {
                    que.add(new info(snake.get(next), temp.turn + 1));
                    visited[snake.get(next)] = temp.turn + 1;
                    continue;

                } else if (ladder.containsKey(next) && visited[next] > temp.turn+1) {
                    que.add(new info(ladder.get(next), temp.turn + 1));
                    visited[ladder.get(next)] = temp.turn + 1;
                    continue;
                }
                if (visited[temp.pos + i] <= temp.turn+1) continue;
                que.add(new info(temp.pos + i, temp.turn + 1));
                visited[temp.pos+i]=temp.turn+1;
            }
        }
    }
}
