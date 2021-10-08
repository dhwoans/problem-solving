package SWEA.exD3;

import java.util.Scanner;

public class Expert2805 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String data ="1\n" +
//                "9\n" +
//                "000304053\n" +
//                "243232532\n" +
//                "042540453\n" +
//                "012450311\n" +
//                "252501310\n" +
//                "532151550\n" +
//                "404542445\n" +
//                "055353403\n" +
//                "303030115";
//
//        sc=new Scanner(data);
        int T = sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            int size= sc.nextInt();
            int arr[][] =new int[size][size];
            //배열담기
            for(int r=0;r<size;r++){
                    String str = sc.next();
                for(int c=0;c<size;c++){
                    arr[r][c]=Character.getNumericValue(str.charAt(c));
                }
            }
           //마름모 찍기
            int empty = (size-1)/2;

            int sum =0;
            for(int x=0;x<arr.length;x++){
                for(int y =0;y<arr.length-empty;y++){
                    if(y<empty)continue;
                    sum+=arr[x][y];
                }

                if(x<(size-1)/2){
                    empty--;
                }else{
                    empty++;
                }
            }
            System.out.println("#"+test_case+" "+sum);
        }
    }
}
