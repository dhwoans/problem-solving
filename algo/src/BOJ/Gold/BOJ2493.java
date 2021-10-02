package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 2493.탑
 *
 * stack을 이용
 *
 */
public class BOJ2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        //배열에 담기
        for (int i = 0; i < arr.length ; i++) {
           arr[i]=Integer.parseInt(st.nextToken());
        }
        //정보 모으기
        Stack<Integer[]> stack = new Stack<>();
        stack.push(new Integer[]{Integer.MAX_VALUE,Integer.MAX_VALUE});
        int start = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            if(start<=arr[i]){
                start=arr[i];
                stack.push(new Integer[]{i,arr[i]});
            }
        }
        int num =0;
        for (int i = 0; i < arr.length; i++) {
            if(i<=stack.peek()[0]){
                sb.append(num).append(" ");
            }else{
               num=stack.pop()[0]+1;
               sb.append(num).append(" ");
            }
        }
        System.out.println(sb);
    }
}
