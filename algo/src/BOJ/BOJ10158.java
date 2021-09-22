package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10158 {//풀이중
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w =Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        int p= Integer.parseInt(st.nextToken());
        int q= Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(br.readLine());
        boolean flag =true;
        boolean flag2 =true;

        while (time!=0){
            time--;
            if(p==0){ flag=true;}
            if(p==w){ flag=false;}
            if(q==0){ flag2=true;}
            if(q==h){ flag2=false;}
            if(flag){
                p++;
            }else{
                p--;
            }
            if (flag2) {
                q++;
            }else {
                q--;
            }



        }
        System.out.println(p+" "+q);

    }
}
