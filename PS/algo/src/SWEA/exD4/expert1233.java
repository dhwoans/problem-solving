package SWEA.exD4;



import java.io.*;
import java.util.StringTokenizer;

public class expert1233 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input1233.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int answer=0;
            boolean flag = true;// 계산 가능 1
            int totalNode = Integer.parseInt(br.readLine());

            for (int i = 0; i < totalNode; i++) {
                String[] str = new String[4];
                StringTokenizer st = new StringTokenizer(br.readLine());
                int z= 0;
                while(st.hasMoreTokens()){
                    str[z]=st.nextToken();
                    z++;
                }
                //str[1]이 숫자 인지 연산자인지 조사
                if (str[1].charAt(0) < 48 || str[1].charAt(0) > 58) {
                    if (str[2]==null) {
                        flag=false;
                    }
                }else{
                    if(str[2]!=null){
                        flag=false;
                    }
                }

            }

            //totalNode짝수인지 조사
            if (totalNode % 2 != 1) {

                flag=false;
            }

        if(flag){
            answer=1;
        }
        System.out.println("#"+test_case+" "+answer);
        }
    }
}
