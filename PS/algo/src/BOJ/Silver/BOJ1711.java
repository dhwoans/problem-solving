package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;



public class BOJ1711 {
    private static class xy{
        private long x;
        private long y;

        xy(long x, long y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        var xies = new ArrayList<xy>();
        var count =0;
        //좌표정보
        for(int i =0;i<n;i++){
            long[] temp = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            xies.add(new xy(temp[0],temp[1]));
        }

        for(int k =0;k<n-2;k++){
            for(int i =k+1;i<n-1;i++){
                for(int j = i+1;j<n;j++){
                    long ab = (xies.get(k).x - xies.get(i).x)*(xies.get(k).x - xies.get(i).x)+(xies.get(k).y - xies.get(i).y)*(xies.get(k).y - xies.get(i).y);
                    long ac = (xies.get(k).x - xies.get(j).x)*(xies.get(k).x - xies.get(j).x)+(xies.get(k).y - xies.get(j).y)*(xies.get(k).y - xies.get(j).y);
                    long bc = (xies.get(i).x - xies.get(j).x)*(xies.get(i).x - xies.get(j).x)+(xies.get(i).y - xies.get(j).y)*(xies.get(i).y - xies.get(j).y);
                    if(ab+ac==bc||ab+bc==ac||ac+bc==ab)count++;
                }
            }
        }
        System.out.println(count);
    }
}
