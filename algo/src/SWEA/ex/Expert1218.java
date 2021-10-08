package SWEA.ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Expert1218 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input1218.txt"));
        Scanner sc = new Scanner(System.in);
        int T =10;
        for(int test_case=1;test_case<=T;test_case++){
            int size =sc.nextInt();
            char[] arr= new char[size];
            //배열담기
            String str =sc.next();
            for(int i =0;i<arr.length;i++){
                arr[i]= str.charAt(i);
            }

            //카운팅하기
            int[] count =new int[8];//    ( , ), [ , ], { , }, < , >

            for(int j=0;j<arr.length;j++){
                switch (arr[j]){
                    case '(':
                        count[0]++;
                        break;
                    case ')':
                        count[1]++;
                        break;
                    case '[':
                        count[2]++;
                        break;
                    case ']':
                        count[3]++;
                        break;
                    case '{':
                        count[4]++;
                        break;
                    case '}':
                        count[5]++;
                        break;
                    case '<':
                        count[6]++;
                        break;
                    case '>':
                        count[7]++;
                        break;
                }
            }
            //검증
            int flag = 1;
            for(int z=0;z<count.length;z+=2){
                if(count[z]!=count[z+1]){
                    flag=0;
                    break;
                }
            }
            System.out.println("#"+test_case+" "+flag);
        }
    }
}
