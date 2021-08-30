package JO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class Jo1205 {//풀이중
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String data = "7\n" +
//                "0 6 5 10 3 0 11";
//        br = new BufferedReader(new StringReader(data));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[1000001];
        int start = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        //배열에 담기
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(st.nextToken())]++;

        }
        //조커숫자 저장
        int joker = arr[0];
        int max = Integer.MIN_VALUE;
        while(start!=arr.length-1){
            arr[0]= joker;
            //시작위치 찾기
            if(arr[start]>0){
                //숫자길이 세기
                int count = 0;
                for (int i = start; i < arr.length; i++) {
                    if (arr[i] == 0) {
                        if (arr[0] != 0) {
                            count++;
                            arr[0]--;
                        } else {
                            start = i;
                            max = Math.max(max, count);
                            break;
                        }
                    } else {
                        count++;
                    }
                }



                }else{
                start++;
            }

        }

        System.out.println(max);
    }
}
