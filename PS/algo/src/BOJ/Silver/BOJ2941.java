package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2941 {
    static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        str=str.replace("c=","1");
        str=str.replace("c-","1");
        str=str.replace("dz=","1");
        str=str.replace("d-","1");
        str=str.replace("lj","1");
        str=str.replace("nj","1");
        str=str.replace("s=","1");
        str=str.replace("z=","1");
        System.out.println(str.length());

    }

}
