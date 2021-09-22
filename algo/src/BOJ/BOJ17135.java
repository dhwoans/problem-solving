package BOJ;

import javax.naming.ldap.Control;
import java.util.Scanner;

/*
* 성을 적에게서 지키기 위해 궁수 3명을 배치하려고 한다.
* 궁수는 성이 있는 칸에 배치할 수 있고, 하나의 칸에는 최대 1명의 궁수만 있을 수 있다.
* 각각의 턴마다 궁수는 적 하나를 공격할 수 있고, 모든 궁수는 동시에 공격한다.
* 궁수가 공격하는 적은 거리가 D이하인 적 중에서 가장 가까운 적이고,
* 그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격한다. 같은 적이 여러 궁수에게 공격당할 수 있다.
* 공격받은 적은 게임에서 제외된다. 궁수의 공격이 끝나면, 적이 이동한다.
* 적은 아래로 한 칸 이동하며, 성이 있는 칸으로 이동한 경우에는 게임에서 제외된다. 모든 적이 격자판에서 제외되면 게임이 끝난다.
 *
* */
public class BOJ17135 {//풀이중

    static int n,m;
    static int r=3;
    static int arr[]=new int[3];
    static boolean isSelect[];
    static enemy[] enemies;

    public static void main(String[] args) {
        String data ="5 5 1\n" +
                "0 0 0 0 0\n" +
                "0 0 0 0 0\n" +
                "0 0 0 0 0\n" +
                "0 0 0 0 0\n" +
                "1 1 1 1 1";

        Scanner sc = new Scanner(System.in);
        sc=new Scanner(data);

        n =sc.nextInt();
        m =sc.nextInt();
        isSelect = new boolean[m];
        int dis=sc.nextInt();
        int[][] map = new int[n+1][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j]=sc.nextInt();
                if(map[i][j]==1){
                    count++;
                }
            }
        }
        //적 좌표 구하기
        int unit=count;
        enemies = new enemy[count];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j]==1){
                    enemies[unit-1]=new enemy(i,j);
                    unit--;
                }
            }
        }

        //거리 계산
        for(int i=0;i<enemies.length;i++){
            for(int j=0;j<m;j++){

            }
        }
        //궁수가 쏜다dfs(0,0);
        //카운트 한다
        //적이 이동한다



    }

    static void dfs(int cnt,int z){
        if(cnt==r){
            for(int x=0;x<arr.length;x++){
                for(int y=0;y<enemies.length;y++){

                }
            }
            for(int x:arr){
                System.out.print(x+" ");
            }
            System.out.println();
            return;
        }

        for(;z<m;z++){
            if(isSelect[z])continue;

            arr[cnt]=z;
            isSelect[z]=true;
            dfs(cnt+1,z);
            isSelect[z]=false;
        }
    }
}
class enemy{
    int r;
    int c;

    public enemy(int r, int c) {
        this.r = r;
        this.c = c;
    }
}