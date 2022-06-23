package BOJ.Silver;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int n  = Integer.parseInt(br.readLine());
        int len = (r+c)*2;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if(dir==1){
                map.put(i+1,dist);
            }else if(dir==2){
                map.put(i+1,r+c+c-dist);
            }else if(dir==3){
                map.put(i+1,c+r+c+r-dist);
            }else if(dir==4){
                map.put(i+1,c+dist);
            }
        }
        //거리비교
        int sum =0;
        for (int i = 0; i < n; i++) {
            int me = map.get(n+1);
            int store = map.get(i+1);
            int dis= Math.abs(store-me);
            sum += Math.min(dis,Math.abs(len- dis));
        }
        System.out.println(sum);

    }
}
