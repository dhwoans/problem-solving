package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int sum=0;
        int num=0;
        int min=0;
        for (int i = 0; i < 10; i++) {
            num= Integer.parseInt(br.readLine());
            sum+=num;
            if(sum>100){
                if(sum-100==100-(sum-num)){
                    min=sum;
                    break;
                }else{
                    min = sum - 100 > 100 - (sum - num) ? sum - num : sum;
                    break;

                }
            }
            min=sum;
        }
        System.out.println(min);
    }
}
