package SWEA.exD4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 4013.특이한 자석
 * <p>
 * 이차원 배열
 */
public class Expert4013 {//풀이중
    static  int[][] path;
    static boolean[] visit;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int K=Integer.parseInt(br.readLine());
            map = new int[4][8];
            visit = new boolean[4];
            //값 입력받기
            for (int i = 0; i < map.length; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < map[i].length; j++) {
                    map[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            path = new int[4][4];
            int[][] value ={{2,0,0},
                            {6,2,0},
                            {0,6,2},
                            {0,0,6}};

            for (int i = 0; i < 3; i++) {
                if(map[i][value[i][i]]!=map[i+1][value[i+1][i]]){
                        path[i][i+1]=1;
                }
            }
            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                check(num-1,dir,value);
                path = new int[4][4];
                for (int z = 0; z < 3; z++) {
                    if(map[z][value[z][z]]!=map[z+1][value[z+1][z]]){
                        if(z==2){
                            path[z+1][z]=1;
                        }
                            path[z][z+1]=1;

                    }
                }
                
            }

            int mag1 =value[0][0]-2<0?8-(value[0][0]-2):value[0][0]-2;
            int mag2 =value[1][0]-2<0?8-(value[1][0]-2):value[1][0]-2;
            int mag3 =value[2][1]-2<0?8-(value[2][1]-2):value[2][1]-2;
            int mag4 =value[3][2]+2>=8?8-(value[3][2]+2):value[3][2]+2;
            int answer=0;

            if(map[0][mag1]==1){
                answer=+1;
            }
            if(map[1][mag2]==1){
                answer+=2;
            }
            if(map[2][mag3]==1){
                answer+=4;
            }
            if(map[3][mag4]==1){
                answer+=8;
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
    static void check(int num, int dir,int[][] arr){

        if(num==0){
            arr[num][num]+=dir;
            if(arr[num][num]<0){
                arr[num][num]=7;
            }else if(arr[num][num]>7){
                arr[num][num]=0;
            }
        }else if(num==3){
            arr[num][num-2]+=dir;
            if(arr[num][num-2]<0){
                arr[num][num-2]=7;
            }else if(arr[num][num-2]>7){
                arr[num][num-2]=0;
            }
        }else{
            arr[num][num]+=dir;
            arr[num][num-1]+=dir;
            if(arr[num][num]<0){
                arr[num][num]=7;
            }else if(arr[num][num]>7){
                arr[num][num]=0;
            }
            if(arr[num][num-1]<0){
                arr[num][num-1]=7;
            }else if(arr[num][num-1]>7){
                arr[num][num-1]=0;
            }
        }

        for (int i = 0; i < 3; i++) {
            if(!visit[i]&&path[num][i]==1){
                visit[num]=true;
                check(i,dir,arr);
            }
        }
    }
}