package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ17143 {//풀이중
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int unit = Integer.parseInt(st.nextToken());

        ArrayList<shark> map = new ArrayList<>();
        //정보 입력
        for (int i = 0; i < unit; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            map.add(new shark(x, y, s, d, z));
        }
        int turn = -1;
        int inven = 0;
        while (turn != c) {
            //사람 움직이기
            turn++;
            //낚시 하기
            Collections.sort(map, new Comparator<shark>() {
                @Override
                public int compare(shark o1, shark o2) {
                    if (o1.c == o2.c) {
                        return o1.r - o2.r;
                    }
                    return o1.c - o2.c;
                }
            });
            for (int i = 0; i < map.size(); i++) {
                if (map.get(i).c == turn) {
                    inven = map.get(i).size;
                    map.remove(i);
                }
            }
            //상어 이동하기
            // 상 0 하 1좌 2 우 3
            int dir[] = {-1, 1, -1, 1};
            for (int i = 0; i < map.size(); i++) {
                if (map.get(i).dir == 0 || map.get(i).dir == 1) {
                    map.get(i).speed = map.get(i).speed % (2 * r - 2);
                    for (int j = 0; j < map.get(i).speed; j++) {
                        if (map.get(i).r == 1) {
                            map.get(i).dir = 1;
                        } else if(map.get(i).r==r) {
                            map.get(i).dir = 0;
                        }
                        map.get(i).r += dir[map.get(i).dir];
                    }
                } else {
                    map.get(i).speed = map.get(i).speed % (2 * r - 2);
                    for (int j = 0; j < map.get(i).speed; j++) {
                        if (map.get(i).c == 1) {
                            map.get(i).dir = 1;
                        } else if(map.get(i).c==c) {
                            map.get(i).dir = 0;
                        }
                        map.get(i).c += dir[map.get(i).dir];

                    }
                }
            }
            for (int i = 0; i < map.size()-1; i++) {
                if(map.get(i).r==map.get(i+1).r&&map.get(i).c==map.get(i+1).c){
                    if(map.get(i).size>map.get(i+1).size){
                        map.remove(i+1);
                    }else{
                        map.remove(i);
                    }
                }
            }

        }
        System.out.println(inven);
    }

}

class shark {
    int r;
    int c;
    int speed;
    int dir;
    int size;

    public shark(int r, int c, int speed, int dir, int size) {
        this.r = r;
        this.c = c;
        this.speed = speed;
        this.dir = dir;
        this.size = size;
    }
}