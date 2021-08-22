package exD3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Expert1225 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data ="1\n" +
                "9550 9556 9550 9553 9558 9551 9551 9551\n" +
                "2\n" +
                "2419 2418 2423 2415 2422 2419 2420 2415";
        sc= new Scanner(data);

        int T =10;
        for(int test_case=1;test_case<=T;test_case++){
            int  w= sc.nextInt();
            //배열에 담기
            Queue<Integer> que = new LinkedList<>();
            for(int i=0;i<8;i++){
                que.offer(sc.nextInt());
            }
            int num =1;
            int count=1;
            while(num!=0){
                if(que.peek()-count<0){
                    num =0;
                }else {
                    num = que.peek() - count;
                }
                if(count%5==0){
                    count=1;
                }else{
                    count++;
                }

                que.offer(num);
                que.poll();

            }
            System.out.print("#"+w);
            for(int x:que){
                System.out.print(" "+x);
            }
            System.out.println();
        }
    }
}
