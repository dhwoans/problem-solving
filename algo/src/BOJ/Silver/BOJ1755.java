package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1755 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to =Integer.parseInt(st.nextToken());
        String num[] =new String[to-from+1];
        int z =0;
        String[] eng = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for (int i = from; i <= to; i++) {
            if(i>=10) {
                String str1 ="";
                str1+=eng[i/10];
                str1+=" ";
                str1+=eng[i%10];
                num[z++]=str1;
            }else {
                num[z++]=eng[i];
            }
        }
        Arrays.sort(num);

        for (int i = 0; i < num.length; i++) {
            if(i!=0&&i%10==0) {
                System.out.println();
            }
            String s=num[i];
            if(Arrays.asList(eng).indexOf(s)==-1){
                st= new StringTokenizer(s);
                String t = st.nextToken();
                String x = st.nextToken();
                System.out.print(Arrays.asList(eng).indexOf(t)+""+Arrays.asList(eng).indexOf(x)+" ");
            }else {
                System.out.print(Arrays.asList(eng).indexOf(s)+" ");

            }
        }
    }

}