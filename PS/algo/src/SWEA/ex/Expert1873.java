package SWEA.ex;

import java.util.Scanner;

public class Expert1873 {
    public static void main(String[] args) {
        String data = "1\n" +
                "3 7\n" +
                "***....\n" +
                "*-..#**\n" +
                "#<.****\n" +
                "23\n" +
                "SURSSSSUSLSRSSSURRDSRDS";

        Scanner sc = new Scanner(System.in);
        sc = new Scanner(data);
        int T = sc.nextInt();
        for (int i = 1; i <= T; i++) {
            int H = sc.nextInt();
            int W = sc.nextInt();
            char map[][] = new char[H][W];
            //배열담기
            for (int r = 0; r < H; r++) {
                String str = sc.next();
                for (int c = 0; c < W; c++) {
                    map[r][c] = str.charAt(c);
                }
            }
            //전차위치 찾기
            int xx = 0;
            int yy = 0;
            for(int x=0;x<H;x++){
                for(int y=0;y<W;y++){
                    if(map[x][y]=='<'||map[x][y]=='^'||map[x][y]=='v'||map[x][y]=='>'){
                        xx=x;
                        yy=y;
                    }
                }
            }

            //명령줄 받기
            int line = sc.nextInt();
            String commend = sc.next();
            for (int j = 0; j < line; j++) {

                switch (commend.charAt(j)) {
                    case 'U'://        U	Up : 전차가 바라보는 방향을 위쪽으로 바꾸고, 한 칸 위의 칸이 평지라면 위 그 칸으로 이동한다.

                        if(xx-1>=0&&map[xx-1][yy]=='.'){
                            map[xx][yy]='.';
                            xx+=-1;
                            map[xx][yy]='^';
                        }else {
                            map[xx][yy]='^';
                        }
                        break;

                    case 'D'://        D	Down : 전차가 바라보는 방향을 아래쪽으로 바꾸고, 한 칸 아래의 칸이 평지라면 그 칸으로 이동한다.

                        if(xx+1<H&&map[xx+1][yy]=='.'){
                            map[xx][yy]='.';
                            xx+=1;
                            map[xx][yy]='v';
                        }else{
                            map[xx][yy]='v';
                        }
                        break;

                    case 'L'://        L	Left : 전차가 바라보는 방향을 왼쪽으로 바꾸고, 한 칸 왼쪽의 칸이 평지라면 그 칸으로 이동한다.

                        if(yy-1>=0&&map[xx][yy-1]=='.'){
                            map[xx][yy]='.';
                            yy+=-1;
                            map[xx][yy]='<';
                        }else {
                            map[xx][yy]='<';
                        }
                        break;
                    case 'R'://        R	Right : 전차가 바라보는 방향을 오른쪽으로 바꾸고, 한 칸 오른쪽의 칸이 평지라면 그 칸으로 이동한다.

                        if(yy+1<W&&map[xx][yy+1]=='.'){
                            map[xx][yy]='.';
                            yy+=1;
                            map[xx][yy]='>';
                        }else{
                            map[xx][yy]='>';
                        }
                        break;
                    case 'S'://        S	Shoot : 전차가 현재 바라보고 있는 방향으로 포탄을 발사한다.
                        if(map[xx][yy]=='<'){
                            for(int s1=yy;s1>=0;s1--){
                                if(map[xx][s1]=='#')break;
                                if(map[xx][s1]=='*'){
                                    map[xx][s1]='.';
                                    break;
                                }
                            }
                        }
                        if(map[xx][yy]=='>'){
                            for(int s2=yy;s2<W;s2++){
                                if(map[xx][s2]=='#')break;
                                if(map[xx][s2]=='*'){
                                    map[xx][s2]='.';
                                    break;
                                }
                            }
                        }
                        if(map[xx][yy]=='^'){
                            for(int s3=xx;s3>=0;s3--){
                                if(map[s3][yy]=='#')break;
                                if(map[s3][yy]=='*'){
                                    map[s3][yy]='.';
                                    break;
                                }
                            }
                        }
                        if(map[xx][yy]=='v'){
                            for(int s4=xx;s4<H;s4++){
                                if(map[s4][yy]=='#')break;
                                if(map[s4][yy]=='*'){
                                    map[s4][yy]='.';
                                    break;
                                }
                            }
                        }
                }

            }
            System.out.printf("#%d",i);
            for (int r1 = 0; r1 < H; r1++) {

                for (int c2 = 0; c2 < W; c2++) {
                    System.out.printf("%c",map[r1][c2]);
                }
                System.out.println();
            }
        }
    }
}






