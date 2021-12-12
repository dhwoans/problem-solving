package Leetcode.medium;

public class Word_Search {
    static boolean[][] visit;
    static boolean flag;


    public static boolean exist(char[][] board, String word) {
        flag=false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visit =new boolean[board.length][board[0].length];
                    check(i,j,board,word,1);
                }
            }
        }
        return flag;
    }

    private static void check(int r,int c,char[][] board,String word,int cnt) {

        if(cnt==word.length()){
            flag=true;
            return;
        }
      //4방탐색
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < 4; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];

            if(nr<0||nc<0||nr>=board.length||nc>=board[0].length)continue;
            if(visit[nr][nc])continue;
            if(board[nr][nc]==word.charAt(cnt)){
                visit[r][c]=true;
                check(nr,nc,board,word,cnt+1);
                visit[r][c]=false;


            }
        }
    }
}

