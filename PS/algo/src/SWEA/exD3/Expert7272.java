package SWEA.exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert7272 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//        String data ="5\n" +
//                "ABCD EFGH\n" +
//                "ABCD PBZO\n" +
//                "PRQO OQAD\n" +
//                "ZXCV HJKL\n" +
//                "BBBB BBB ";
//        br=new BufferedReader(new StringReader(data));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            boolean flag = true;
            if(str1.length()!=str2.length()){
                System.out.println("#"+test_case+" "+"DIFF");
                continue;
            }
            for (int i = 0; i < str1.length(); i++) {
                if(check(str1.charAt(i))!=check(str2.charAt(i))){
                    System.out.println("#"+test_case+" "+"DIFF");
                    flag= false;
                    break;
                }
            }
            if(flag){
                System.out.println("#"+test_case+" "+"SAME");
            }
        }
    }
    static int check(char alpa){

        switch (alpa){
            case 'A': case 'D': case'O': case'P': case'Q': case'R':
                return 1;
            case 'B':
                return 2;
            default:
                return 0;
        }
    }
}
