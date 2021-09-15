package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[10000];
        int T = Integer.parseInt(br.readLine());
        int size =0;
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();

            switch (commend){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    arr[size++]=num;
                    break;
                case "pop":
                    if(size>0){
                        System.out.println(arr[size-1]);
                        arr[size]=0;
                        size--;
                    }else{
                        System.out.println("-1");
                    }

                    break;
                case "size":
                    System.out.println(size);
                    break;
                case "empty":
                    if(size==0){
                        System.out.println("1");
                    }else{
                        System.out.println("0");
                    }
                    break;
                case "top":
                    if(size==0){
                        System.out.println(-1);
                    }else{
                        System.out.println(arr[size-1]);
                    }
                    break;
            }
        }
    }
}
