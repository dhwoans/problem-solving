package programmers.Lv1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 크레인인형뽑기게임 {
    public int solution(int[][] board, int[] moves) {
        ArrayList<Queue<Integer>> list = new ArrayList<>();
        Stack<Integer> basket = new Stack<>();
        int answer =0;
        for (int i = 0; i < board[0].length; i++) {
            list.add(new LinkedList<>());
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]==0)continue;
                list.get(j).add(board[i][j]);

            }

        }
        for (int i = 0; i < moves.length; i++) {
            int move = list.get(moves[i]-1).isEmpty()?0:list.get(moves[i]-1).poll();
            System.out.println(move);
            if(basket.isEmpty()){
                if(move==0)continue;
                basket.add(move);
            }else{
                if(basket.peek()==move){
                    basket.pop();
                    answer++;
                }else{
                    if(move==0)continue;
                    basket.add(move);
                }
            }
        }
        return answer*2;
    }
}