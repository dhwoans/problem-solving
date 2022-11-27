package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 10814.나이순 정렬
 *
 * comparetor를 이용한 정렬
 *
 */
public class BOJ10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String[][] arr = new String[len][3];
        //배열담기
        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = st.nextToken();
            arr[i][1] = Integer.toString(i);
            arr[i][2] = st.nextToken();

        }

        Arrays.sort(arr,(o1, o2) ->  {
            if(o1[0]==o2[0]){
                return Integer.parseInt(o1[1])-Integer.parseInt(o2[1]);
            }
            return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
        });

        for (String[] a : arr) {
            System.out.println(a[0]+" "+a[2]);
        }
    }
}
