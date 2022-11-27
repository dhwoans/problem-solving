package SWEA.exD3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Expert5431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String data =
                "2\n" +
                "5 3\n" +
                "2 5 3\n" +
                "7 2\n" +
                "4 6";
        br=new BufferedReader(new StringReader(data));
        int T =Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int all= Integer.parseInt(st.nextToken());
            int n=Integer.parseInt(st.nextToken());
            String submit =br.readLine();
            st= new StringTokenizer(submit);
            boolean[] student = new boolean[all+1];
            for (int i = 0; i <n; i++) {
                student[Integer.parseInt(st.nextToken())]=true;

            }
            System.out.print("#"+test_case+" ");
            for (int i = 1; i < student.length ; i++) {
                if(!student[i])
                System.out.print(i+" ");

            }
            System.out.println();

        }

    }
}
