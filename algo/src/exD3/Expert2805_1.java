package exD3;

import java.util.Scanner;

public class Expert2805_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String data ="1\n" +
//                "5\n" +
//                "14054\n" +
//                "44250\n" +
//                "02032\n" +
//                "51204\n" +
//                "52212";
//        sc = new Scanner(data);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int N =sc.nextInt();
            int[][] map = new int[N][N];
            //배열에 담기
            for (int i = 0; i < map.length; i++) {
                String str = sc.next();
                for (int j = 0; j < map.length; j++) {
                    map[i][j]=Character.getNumericValue(str.charAt(j));
                }
            }
            int center = N/2;
            int count =0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    int dis = Math.abs(center-i)+Math.abs(center-j);
                    if(dis<=center){
                        count+=map[i][j];
                    }
                }
            }
            System.out.println("#"+test_case+" "+count);
        }
    }
}
