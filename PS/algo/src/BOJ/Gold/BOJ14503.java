package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ14503 {
    private static class xy{
        int x;
        int y;

        private xy(int x,int y){
            this.x= x;
            this.y= y;
        }
    }

    private static class robot{
        xy pos;
        int dir;
        int count;

        private robot(int x,int y,int dir){
            this.pos = new xy(x,y);
            this.dir = dir;
            this.count =0;
        }
        //청소
        private void clean(){
            count++;
        }
        //탐색
        private boolean search(int[][] map){


            for (int i = 0; i < 4; i++) {
                int x =0;
                int y =0;
                int ch=0;
                if(dir==0){
                    y-=1;
                    ch =3;
                }
                else if(dir==1){
                    x-=1;
                    ch=0;
                }
                else if(dir==2){
                    y+=1;
                    ch=1;
                }
                else if(dir==3) {
                    x+=1;
                    ch=2;
                }

                if(map[pos.x+x][pos.y+y]==0) {
                    dir = ch;
                    pos.x += x;
                    pos.y += y;
                    return true;
                }else{
                    dir =ch;
                }
            }
            // 청소 할곳 없음
            return back(map);

        }
        //후진
        private boolean back(int[][] map){
            int x =0;
            int y =0;

            if(dir==0) x+=1;
            else if(dir==1)y-=1;
            else if(dir==2)x-=1;
            else y+=1;

            if(map[pos.x+x][pos.y+y]==1){
                return false;
            }
            pos.x+=x;
            pos.y+=y;
            return true;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());


        //맵 정보
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                map[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        robot rb = new robot(x, y, dir);

        while(true){
            //현재 위치 청소
            if(map[rb.pos.x][rb.pos.y]==0){
                rb.clean();
                map[rb.pos.x][rb.pos.y]=3;
            }
            //탐색
            boolean result =rb.search(map);

            if(!result){
                break;
            }

        }
        System.out.println(rb.count);
    }
}
