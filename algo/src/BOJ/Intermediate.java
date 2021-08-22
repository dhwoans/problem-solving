package BOJ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Intermediate {
    public static void main(String[] args) throws FileNotFoundException {
      System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input_intermidate.txt"));




        Scanner sc =new Scanner(System.in);

        int T = sc.nextInt();
        for(int i=0;i<T;i++){
            int count=0;
            int size=sc.nextInt();
            char[][] chars = new char[size][size];
            int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};//상 하 좌 우
            //배열담기
            for(int j=0;j< chars.length;j++){
                String str = sc.next();
                for(int z=0;z< chars.length;z++){
                    chars[j][z]=str.charAt(z);
                }
            }
            //탐색
            for(int r=0;r<chars.length;r++){
                for(int c=0;c<chars.length;c++){
                    //A,B,C 찾기
                    switch (chars[r][c]){
                        case 'A':
                            //4방탐색
                            for(int g=0;g<4;g++){
                                int nr = r+dir[g][0];
                                int nc = c+dir[g][1];
                                //범위 벗어남
                                if(nr<0||nc<0||nr>=chars.length||nc>= chars.length) continue;
                                if(chars[nr][nc]=='H'){
                                    chars[nr][nc]='X';
                                }
                            }
                            break;
                        case 'B':
                            //4방탐색
                            for(int g=0;g<4;g++){
                                for(int x=1;x<3;x++) {
                                    int nr = r + (dir[g][0]*x);
                                    int nc = c + (dir[g][1]*x);
                                    //범위 벗어남
                                    if(nr<0||nc<0||nr>=chars.length||nc>= chars.length) continue;

                                    if (chars[nr][nc] == 'H') {
                                        chars[nr][nc] = 'X';
                                    }
                                }
                            }
                            break;
                        case 'C':
                            //4방탐색
                            for(int g=0;g<4;g++){
                                for(int x=1;x<4;x++) {
                                    int nr = r + (dir[g][0]*x);
                                    int nc = c + (dir[g][1]*x);
                                    //범위 벗어남
                                    if(nr<0||nc<0||nr>=chars.length||nc>= chars.length) continue;

                                    if (chars[nr][nc] == 'H') {
                                        chars[nr][nc] = 'X';
                                    }
                                }
                            }
                    }

                }
            }
            for(char[] u:chars){
                for(char p:u){
                    if(p=='H'){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
