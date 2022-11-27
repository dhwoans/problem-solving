package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ1062 {

    private static int k;
    private static int n;
    private static String[] str;
    private static boolean[] visited;
    private static int answer;
//    private static HashSet<Character> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        answer = 0;
        str = new String[n];
        List<Character> list = new ArrayList<>();
        visited = new boolean[27];
        if(k <5){
            System.out.println(0);
            return ;
        }

        k -=5; //a n t i c 제거

        visited[0]=true;
        visited['n'-'a']=true;
        visited['t'-'a']=true;
        visited['i'-'a']=true;
        visited['c'-'a']=true;
//        set = new HashSet<>();
//
//        set.add('a');
//        set.add('n');
//        set.add('t');
//        set.add('i');
//        set.add('c');

        for (int i = 0; i < str.length; i++) {
            String temp = br.readLine();
            StringBuilder val = new StringBuilder();
            for (int j = 0; j < temp.length() ; j++) {
                char check = temp.charAt(j);
                if(!visited[check-'a']){
                    val.append(check);
                    list.add(check);
                }
            }
            str[i]=val.toString();
        }

        list = list.stream().distinct().collect(Collectors.toList());
        dfs(0,0);
        System.out.println(answer);
    }

    private static void dfs(int cnt,int start) {
        if(cnt==k){
            cal();
            return;
        }
        for (int i = start; i < visited.length; i++) {
            if(visited[i])continue;
            visited[i]=true;
            dfs(cnt+1,i);
            visited[i]=false;
        }
    }

    private static void cal() {
        int count =0;
        for (String s : str) {
            boolean flag = true;
            for (int j = 0; j < s.length(); j++) {
                if (!visited[s.charAt(j) - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }
        answer = Math.max(answer,count);
    }
}
