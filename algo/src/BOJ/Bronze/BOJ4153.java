package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 4153.직각삼각형
 *
 * 직각삼각형이면 피타고라스정리가 사용가능하다
 *
 * 가장 긴 변이 대각선
 *
 * EOF유의
 */
public class BOJ4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        while (true){
            int[] num = new int[3];
            int max= 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < num.length; i++) {
                num[i]=Integer.parseInt(st.nextToken());
                if(max<num[i]){
                    max=num[i];
                }
            }

            if(num[0]==0){
                break;
            }
            int n=0;
            for (int i = 0; i < num.length; i++) {
                if(num[i]==max){
                    max=(int)(Math.pow(num[i],2));
                }else{
                    n+=(int)(Math.pow(num[i],2));
                }
            }
            if(max==n){
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }

        }
    }
}
