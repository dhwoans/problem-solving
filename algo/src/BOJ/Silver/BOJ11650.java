package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/***
 * 11650.좌표 정렬하기
 * comparetor로 풀면됨
 */
public class BOJ11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][2];
        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x =Integer.parseInt(st.nextToken());
            int y =Integer.parseInt(st.nextToken());
            arr[i][0]=x;
            arr[i][1]=y;
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                   return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        for (int[] ints : arr) {
            for (int a : ints) {
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
