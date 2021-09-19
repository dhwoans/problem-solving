package ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Expert1940 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input1940.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            int commend =sc.nextInt();
            int speed=0;
            int answer=0;
            for(int i=0;i<commend;i++){
                int aaa=sc.nextInt();
                switch (aaa){
                    case 1:
                        speed+=sc.nextInt();
                        break;
                    case 2:

                        speed-=sc.nextInt();
                        break;
                    case 0:
                        break;

                }
                if(speed<0) speed=0;
                answer+=speed;
            }
                System.out.printf("#%d %d\n",test_case,answer);
        }
    }

}
