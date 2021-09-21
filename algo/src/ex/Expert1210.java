package ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Expert1210 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input1210.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

            for(int i =0;i<T;i++) {
                int start = 99;
                int point = 0;
                int dir[][] = {{0, -1}, {0, 1}, {-1, 0}};//좌 우 상
                int arr[][] = new int[100][100];
                //배열에 담기
                for (int r = 0; r < arr.length; r++) {
                    for (int c = 0; c < arr.length; c++) {
                        arr[r][c] = sc.nextInt();
                    }
                }
                //2찾기
                for (int z = 0; z < arr.length; z++) {
                    if (arr[start][z] == 2) {
                        point = z;

                        break;
                    }
                }

                //움직이기
                int x= 2;
                while(start!=0){
                    int nr = start + dir[x][0];
                    int nc = point + dir[x][1];
                    //범위에 벗어남
                    if(nr<0||nc<0||nr>=100||nc>=100){
                        x=2;
                        continue;

                    }


                    start=nr;
                    point=nc;
                }


            }







        }
    }

