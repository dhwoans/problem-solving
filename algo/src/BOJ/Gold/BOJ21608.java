package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ21608 {

    private static int[][] map;
    private static ArrayList<Set<Integer>> arr;
    private static PriorityQueue<priorty> que;
    private static int student;
    private static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    private static int answer;

    private static class priorty implements Comparable<priorty>{
        int like;
        int empty;
        int r;
        int c;
        private priorty(int like,int empty,int r,int c){
            this.like = like;
            this.empty = empty;
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(priorty o) {
            if(this.like==o.like){
                if(this.empty==o.empty){
                    if(this.r==o.r){
                        return this.c - o.c;
                    }
                    return this.r - o.r;
                }
                return o.empty-this.empty;
            }
            return o.like-this.like;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        //맵만들기
        map = new int[N][N];
        //N*N+1 만큼 배열 만들기
        for (int i = 0; i < N*N+1; i++) {
            arr.add(new HashSet<>());
        }
        LinkedList<Integer> order = new LinkedList<>();
        for (int i = 0; i < N*N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            //학생 순서 저장
            order.add(student);
            //선호하는 학생 저장
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                arr.get(student).add(Integer.parseInt(st.nextToken()));
            }
        }
//        비어있는 칸 중에서 좋아하는 학생이 인접한 칸에 가장 많은 칸으로 자리를 정한다.
//        1을 만족하는 칸이 여러 개이면, 인접한 칸 중에서 비어있는 칸이 가장 많은 칸으로 자리를 정한다.
//        2를 만족하는 칸도 여러 개인 경우에는 행의 번호가 가장 작은 칸으로, 그러한 칸도 여러 개이면 열의 번호가 가장 작은 칸으로 자리를 정한다.
        //자리에 앉히기
        while (!order.isEmpty()){
            que = new PriorityQueue<>();
            student = order.pop();
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    //만약 빈칸이면
                    if(map[i][j]==0){
                        countCheck(i,j,que);
                    }
                }
            }
            priorty xy = que.poll();
            map[xy.r][xy.c]= student;
        }
        //계산하기
        answer = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                likeCheck(i, j);
            }
        }
        System.out.println(answer);
    }

    private static void likeCheck(int r, int c) {
        int like =0;
        for (int k = 0; k < 4; k++) {
            int nx = r + dir[k][0];
            int ny = c + dir[k][1];

            if(nx<0||ny<0||nx>=map.length||ny>=map[0].length)continue;
            if(arr.get(map[r][c]).contains(map[nx][ny]))like++;
        }
        if(like==1) answer+=1;
        else if(like==2) answer+=10;
        else if(like==3) answer+=100;
        else if(like==4) answer+=1000;
    }

    private static void countCheck(int r,int c,PriorityQueue que) {
        int like =0;
        int empty =0;

        for (int i = 0; i < 4; i++) {
            int nx = r + dir[i][0];
            int ny = c + dir[i][1];

            if(nx<0||ny<0||nx>=map.length||ny>=map[0].length)continue;
            //좋아하는 학생 체크
            if(arr.get(student).contains(map[nx][ny]))like++;
            //빈자리 체크
            if(map[nx][ny]==0)empty++;
        }
        que.add(new priorty(like,empty,r,c));
    }
}
