package BOJ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Peak {
    public static void main(String[] args) throws FileNotFoundException {
        String data = "5\n" +
                "5 3 7 2 3\n" +
                "3 7 1 6 1\n" +
                "7 2 5 3 4\n" +
                "4 3 6 4 1\n" +
                "8 7 3 5 2";


        Scanner sc = new Scanner(System.in);
        sc = new Scanner(data);
        //이차원 배열 담기
        int T = Integer.parseInt(sc.next());
        int[][] arr = new int[T][T];
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};//상,하,좌,우
        boolean flag =false;
        int count = 0;

        for(int i =0;i<T;i++){
            for(int j=0;j<T;j++){
                arr[i][j] = Integer.parseInt(sc.next());
            }
        }
       //탐색
        for(int r=0;r<T;r++){
            for(int c=0;c<T;c++){
               //4방탐색
                for(int z=0;z<4;z++){
                    int nr = r + dir[z][0];
                    int nc = c + dir[z][1];
                    //범위에서 벗어남
                    if(nr<0 || nc<0 || nr>=T || nc>=T) continue;

                    if(arr[r][c]<=arr[nr][nc]){
                        flag =false;
                        break;
                    }else{
                        flag=true;
                    }

                }
                if(flag==true){
                    count++;
                }

            }
        }
        System.out.println(count);
    }
}









