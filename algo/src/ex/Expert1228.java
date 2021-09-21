package ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Expert1228 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input1228.txt"));
        Scanner sc = new Scanner(System.in);
        for(int test_case=1;test_case<=10;test_case++){
            int size = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<Integer>();
            for(int i=0;i<size;i++){
                arr.add(sc.nextInt());
            }

            int count = sc.nextInt();
            for(int j=0;j<count;j++){
                char start=sc.next().charAt(0);
                if(start=='I'){
                    int index =sc.nextInt();
                    int time =sc.nextInt();
                    for(int z=0;z<time;z++){
                        arr.add(index+z,sc.nextInt());
                    }
                }
            }
            System.out.print("#"+test_case+" ");
            for(int x=0;x<10;x++){
                System.out.print(arr.get(x)+" ");
            }
            System.out.println();
        }
    }
}
