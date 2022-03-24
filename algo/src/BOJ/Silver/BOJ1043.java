package BOJ.Silver;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1043 {

    private static ArrayList<ArrayList<Integer>> order;
    private static ArrayList<Integer> know;
    private static boolean[] visited;
    private static int[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //거짓말을 알고 있는 사람
        st = new StringTokenizer(br.readLine());
        int howmany = Integer.parseInt(st.nextToken());
        know = new ArrayList<>();
        for (int i = 0; i < howmany; i++) {
            know.add(Integer.parseInt(st.nextToken()));
        }
        map = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        order = new ArrayList<>();

        //정보 입력
        for (int i = 0; i < m; i++) {
            order.add(new ArrayList<>());
            st = new StringTokenizer(br.readLine());
            int people = Integer.parseInt(st.nextToken());
            for (int j = 0; j < people; j++) {
                order.get(i).add(Integer.parseInt(st.nextToken()));
            }
        }

        //간선 연결
        for (int i = 0; i < order.size(); i++) {
            for (int j = 0; j < order.get(i).size()-1; j++) {
                for (int k = j+1; k < order.get(i).size(); k++) {
                    int x = order.get(i).get(j);
                    int y = order.get(i).get(k);

                    map[x][y] = 1;
                    map[y][x] = 1;
                }
            }

        }
        bfs();

        //체크
        int answer = 0;
        for (int i = 0; i < order.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < order.get(i).size(); j++) {
                int person = order.get(i).get(j);
                if (visited[person]) {
                    flag = false;
                    break;
                }
            }
            if (flag) answer++;
        }
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        for (Integer i : know) {
            que.add(i);
            visited[i] = true;
        }
        while (!que.isEmpty()) {
            int z = que.poll();

            for (int i = 0; i < map[0].length; i++) {
                if (map[z][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    que.add(i);
                }
            }
        }
    }
}