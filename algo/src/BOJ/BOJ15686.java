package BOJ;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ15686 {
    static int count2;
    static int r;
    static int[] arr;
    static boolean[] isSelect;
    static house[] h;
    static kfc[] k;
    static int chickenLoad;
    static int sum;
    static int min;
    static int min2=Integer.MAX_VALUE;
    public static void main(String[] args) {
        String data ="5 2\n" +
                "0 2 0 1 0\n" +
                "1 0 1 0 0\n" +
                "0 0 0 0 0\n" +
                "2 0 0 1 1\n" +
                "2 2 0 1 2";

        Scanner sc = new Scanner(System.in);
        sc=new Scanner(data);
        int size = sc.nextInt();
        r =sc.nextInt();
        arr=new int[r];

        int[][] map = new int[size][size];
        int count1=0;
        count2=0;
        //배열담기
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map.length;j++){
                map[i][j]=sc.nextInt();
                if(map[i][j]==1){ count1++;
            }else if(map[i][j]==2) count2++;

            }
        }
        isSelect=new boolean[count2];
        //1좌표 찾기 2좌표 찾기
        h = new house[count1];
        int num=0;
        k = new kfc[count2];
        int num1=0;
        for(int r=0;r<map.length;r++){
            for(int c=0;c<map.length;c++){
                if(map[r][c]==1){
                    h[num]=new house(r,c);
                    num++;
                }else if(map[r][c]==2){
                    k[num1]=new kfc(r,c);
                    num1++;
                }

            }
        }
        dfs(0,0 );
        System.out.println(min2);


    }
    static void dfs(int cnt,int i){
        if(cnt==r){
            for(int z=0;z<h.length;z++){
                min=Integer.MAX_VALUE;
                for(int j=0;j<arr.length;j++){
                    chickenLoad=Math.abs(k[arr[j]].r-h[z].r)+Math.abs(k[arr[j]].c-h[z].c);
//
                    min = Math.min(min,chickenLoad);

                }
                sum+=min;

            }

            min2=Math.min(sum,min2);

            sum=0;

            return;
        }
        for(;i<count2;i++){
            if(isSelect[i]) continue;
            arr[cnt]=i;
            isSelect[i]=true;
            dfs(cnt+1,i);
            isSelect[i]=false;
        }
    }

}
class house{
    int r;
    int c;

    public house(int r, int c) {
        this.r = r;
        this.c = c;
    }
}
class kfc{
    int r;
    int c;

    public kfc(int r, int c) {
        this.r = r;
        this.c = c;
    }
}