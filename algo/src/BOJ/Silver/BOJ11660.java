package BOJ.Silver;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //값 입력
        int sum =0;
        int[] map = new int[N*N];
        for (int i = 0; i < N; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i*N+j]= Integer.parseInt(st.nextToken());
                sum+=map[i*N+j];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken())-1;
            int startY = Integer.parseInt(st.nextToken())-1;
            int endX = Integer.parseInt(st.nextToken())-1;
            int endY = Integer.parseInt(st.nextToken())-1;

            int start=N*startX+startY;
            int end=N*endX+endY;

            int len = end - start;
            int answer=0;
            if(len<=map.length-len){
                for (int j = start; j <= end; j++) {
                    answer +=map[j];
                }
            }else{
                for (int j = 0; j < start; j++) {
                    answer +=map[j];
                }
                for (int j = end+1; j <map.length ; j++) {
                    answer +=map[j];
                }
                answer=sum-answer;
            }
            sb.append(answer+"\n");

        }
        System.out.println(sb);
    }
}
