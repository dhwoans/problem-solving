package SWEA.ex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Expert1974 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input1974.txt"));
        Scanner sc = new Scanner(System.in);

        int T =sc.nextInt();
     for(int test_case=1;test_case<=T;test_case++){
        boolean flag =true;
            int[][] arr = new int[9][9];
            int amount=0;
            //배열에 담기
            for(int r=0;r<arr.length;r++){
                for(int c=0;c<arr.length;c++){
                    arr[r][c]=sc.nextInt();
                }
            }

            //가로 검증
           if(flag){
            out:for(int r=0;r<arr.length;r++){
                amount=0;
                for(int c=0;c<arr.length;c++){
                       amount+=arr[r][c];
                }
                //검증
               if(amount!=45){
                   flag=false;
                   break out;
                }
            }

           }
            //세로검증
         if(flag) {
            out:for(int c=0;c<arr.length;c++){
                amount=0;
                for(int r=0;r<arr.length;r++){
                    amount+=arr[r][c];
                }
                //rrr 검증
                if(amount!=45){
                    flag=false;
                    break out;
                    }
                }
            }



            //3x3검증
         if(flag){
            out:for(int r=0;r<=6;r+=3){

                for(int c=0;c<=6;c+=3){
                    amount =0;
                    for(int i=0;i<3;i++){
                        for(int j=0;j<3;j++){
                            amount+=arr[r+i][c+j];
                        }
                    }
                        //rrr 검증
                    if(amount!=45){
                        flag=false;
                        break out;
                        }
                }
            }

         }if(flag==true){

            System.out.printf("#%d %d\n",test_case,1);
         }else{
             System.out.printf("#%d %d\n",test_case,0);
        }
     }
    }
}
