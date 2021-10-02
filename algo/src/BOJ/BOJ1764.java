package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 1764.듣보잡
 *
 * 탐색문제
 *
 * 알파벳을 인덱스로 이용
 *
 * arraylist 만들어서 탐색 -> 시간 초과
 *      *   *   *
 * 단순하게 생각하자
 *
 * 배열2개 만들어서 탐색-> 시간 초과
 *     *    *   *
 * set을 이용하자
 * HashSet 시간 복잡도
 * add         :   O(1)
 * contains    :   O(1)
 * next        :   o(h/n)
 */
public class BOJ1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =Integer.parseInt(st.nextToken());
        int M =Integer.parseInt(st.nextToken());

        Set<String> set= new HashSet();
        StringBuilder sb = new StringBuilder();
        int count=0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            set.add(s);
        }

        ArrayList<String> str = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String s1 =br.readLine();
            if(set.contains(s1)){
                count++;
               str.add(s1);
            }
        }
        Collections.sort(str);
        System.out.println(count);
        str.stream().forEach(s -> System.out.println(s));
    }
}
