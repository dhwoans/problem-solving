package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BOJ3711 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int g = Integer.parseInt(br.readLine());
            int[] arr = new int[g];
            for (int j = 0; j < g; j++) {
                arr[j]=Integer.parseInt(br.readLine());
            }
            int answer =0;
            for (int j = 1; j < 1_000_000; j++) {
//                Set<Integer> set = new HashSet<>();
                ArrayList<Integer> set = new ArrayList<>();
                for (int value : arr) {
                    if(set.contains(value % j)){
                        break;
                    }else{
                        set.add(value % j);
                    }

                }
                if(set.size()==g){
                    answer =j;
                    break;
                }

            }
            System.out.println(answer);
        }
        
    }
}
