package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ17140 {
    private static class countNum{
        int num;
        int count;

        private countNum(int num,int count){
           this.num=num;
           this.count=count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r  = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x =3;
        int y =3;
        int tempX=3;
        int tempY=3;
        int count =0;
        int[][] map = new int[102][102];
        //2차원 배열에 넣기
        for (int i = 1; i <= x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= y; j++) {
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        int answer =0;
        if(map[r][c]==k){
            System.out.println(answer);
            return;
        }
        while (answer<100){
                answer++;
                HashMap<Integer, Integer> hashmap = new HashMap<>();
                PriorityQueue<countNum> que = new PriorityQueue<>((o1, o2) -> {
                    if(o1.count== o2.count){
                        return o1.num-o2.num;
                    }
                    return o1.count-o2.count;});

            if(x>=y){//R연산

                //(수,등장횟수 저장)
                for (int i = 1; i <= x; i++) {
                    hashmap.clear();
                    for (int j = 1; j <= y; j++) {
                        hashmap.put(map[i][j],hashmap.getOrDefault(map[i][j],0)+1);
                    }
                    //순서 정렬
                    for (Integer key : hashmap.keySet()) {
                        if(key==0)continue;
                        que.add(new countNum(key, hashmap.get(key)));
                    }
                    //행 길이 계산
                    int lenY =que.size()*2;
                    tempY = Math.max(tempY,lenY);
                    //2차원 배열에 반영
                    for (int j = 1; j <= map[0].length; j+=2) {
                        if(que.isEmpty())break;
                        countNum temp = que.poll();
                        map[i][j]=temp.num;
                        map[i][j+1]=temp.count;
                    }
                    //뒤에 0이 아니면 0으로
                    for (int j = lenY+1; j <map[0].length ; j++) {
                        if(map[i][j]!=0){
                            map[i][j]=0;
                        }
                    }
                }
            }else{//C연산

                //(수,등장횟수 저장)
                for (int i = 1; i <= y; i++) {
                    hashmap.clear();
                    for (int j = 1; j <= x; j++) {
                        hashmap.put(map[j][i],hashmap.getOrDefault(map[j][i],0)+1);
                    }
                    //순서 정렬
                    for (Integer key : hashmap.keySet()) {
                        if(key==0)continue;
                        que.add(new countNum(key, hashmap.get(key)));
                    }
                    //열 길이 계산
                    int lenX =que.size()*2;
                    tempX = Math.max(tempX, lenX);
                    //2차원 배열에 반영
                    for (int j = 1; j <= map.length ; j+=2) {
                        if(que.isEmpty())break;
                        countNum temp = que.poll();
                        map[j][i]=temp.num;
                        map[j+1][i]=temp.count;
                    }
                    //뒤에 0이 아니면 0으로
                    for (int j = lenX+1; j < map.length; j++) {
                        if(map[j][i]!=0){
                            map[j][i]=0;
                        }
                    }
                }
            }
            //값일치확인
            if(map[r][c]==k){
                System.out.println(answer);
                return;
            }
            //행 열 길이 갱신
            x=tempX;
            y=tempY;
        }
        //실패
        System.out.println(-1);
    }
}
