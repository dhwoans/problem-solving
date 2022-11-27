package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int answer = n1*n2;
        if(n1<n2){
            int temp = n2;
            n2 =n1;
            n1 = temp;
        }

        while(true){
            int n3 = n1%n2;
            n1=n2;
            n2=n3;
            if(n3==0)break;
        }

        System.out.println(n1);
        System.out.println(answer/n1);
    }
}
