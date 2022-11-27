package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int point = -1;
            int point2 = 0;
            int point3 =0;

            String str= br.readLine();
            int[] arr = new int[str.length()];
            //배열에 담기
            for (int j = 0; j < arr.length; j++) {
                arr[j]=str.charAt(j)-'0';
            }
            //step 1
            for (int j = arr.length-1; j >=1 ; j--) {
                if(arr[j]>arr[j-1]){
                    point =j-1;
                    point2 =j;
                    break;
                }
            }
            if(point==-1){
                sb.append("BIGGEST");
                sb.append("\n");
                continue;
            }
            //step 2
            for (int j = arr.length-1; j > point ; j--) {
                if(arr[j]>arr[point]){
                    point3 =j;
                    break;
                }
            }
            //swap
            Swap(point, point3,arr);
            //step 3
            int end = arr.length-1;
            while(point2<end){
                Swap(point2,end,arr);
                point2++;
                end--;
            }
            for (int i1 : arr) {
                sb.append(i1);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void Swap(int point, int point3,int[] arr) {
        int temp = arr[point];
        arr[point] = arr[point3];
        arr[point3]= temp;
    }
}
