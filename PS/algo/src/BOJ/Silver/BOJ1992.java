package BOJ.Silver;

import java.util.Scanner;

public class BOJ1992 {
    static int map[][];
    static int n;
    static int r = 0;
    static int c = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = "8\n" +
                "11110000\n" +
                "11110000\n" +
                "00011100\n" +
                "00011100\n" +
                "11110000\n" +
                "11110000\n" +
                "11110011\n" +
                "11110011";
        sc = new Scanner(data);
        boolean flag = true;
        n = sc.nextInt();
        map = new int[n][n];
        // 배열에 넣기
        for (int i = 0; i < map.length; i++) {
            String str = sc.next();
            for (int j = 0; j < map.length; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        //시작


        //전체탐색->재귀
        int check = map[0][0];
        boolean flag1 = false;







        search(n,0,0);

        System.out.println(sb);

    }

    static void search(int n, int starti, int startj) {
        boolean flag = false;
        int check = map[starti][startj];
        out:
        for (int i = starti; i < n + starti; i++) {
            for (int j = startj; j < n + startj; j++) {
                if (check == map[i][j]) {
                    flag = true;
                    continue;
                } else {
                    flag = false;
                    n /= 2;
                    sb.append("(");
                    search(n, starti, startj);
                    search(n, starti,startj + n);
                    search(n, starti + n, startj);
                    search(n, starti + n, startj + n);
                    sb.append(")");
                    break out;
                }
            }
        }
        if (flag) {

            sb.append(check);

//            sb.append("<-"+"r:"+starti+"y:"+startj+" ");
        }


    }
}
