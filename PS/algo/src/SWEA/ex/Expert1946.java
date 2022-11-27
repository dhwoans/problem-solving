package SWEA.ex;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Expert1946 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input1946.txt"));
        Scanner sc = new Scanner(System.in);
        int T=sc.nextInt();
        for(int i=1;i<=T;i++){
            int count =0;
            int totalchar =sc.nextInt();
            System.out.println("#"+i);
            for(int j=0;j<totalchar;j++){

                char ch = sc.next().charAt(0);
                int round = sc.nextInt();
                for(int z=0;z<round;z++){

                    System.out.print(ch);
                    count++;
                    if(count%10==0){
                        System.out.println(

                        );
                    }

                }
            }
            System.out.println();
        }

    }
}
