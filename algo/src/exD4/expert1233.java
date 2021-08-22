package exD4;

import ex.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class expert1233 {//풀이중
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input1233.txt"));
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case<=10; test_case++){
            int size =sc.nextInt();
            ArrayList<String> arr = new ArrayList<>();
            for(int i=0;i<size;i++){
                arr.add(sc.nextInt(),sc.next());
            }
            System.out.println(arr);
        }
    }
}
