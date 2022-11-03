package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Dragons {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        var s = Integer.parseInt(st.nextToken());
        var n = Integer.parseInt(st.nextToken());
        Integer[][] monster = new Integer[n][2];
        //정보 받기
        for (int i = 0; i < n; i++) {
            monster[i]  = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        }
        //정렬
        Arrays.sort(monster,Comparator.comparing((Integer[] o) -> o[0]).thenComparing((Integer[] o)-> -o[1]));
        //비교
        for (Integer[] i : monster) {
            if(s<=i[0]){
                System.out.println("NO");
                return;
            }else{
                s+=i[1];
            }
        }
        System.out.println("YES");
    }
}
