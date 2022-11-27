package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2800 {

    private static ArrayList<Integer[]> brackets;
    private static boolean[] visited;
    private static PriorityQueue<String> que;
    private static char[] str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().toCharArray();
        //괄호 찾기
        Stack<Integer> stack = new Stack<>();
        brackets = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            if (str[i] != '(' && str[i] != ')') continue;
            if (stack.isEmpty() || str[i] == '(') stack.add(i);
            else if (str[i] == ')') brackets.add(new Integer[]{stack.pop(), i});
        }
        que = new PriorityQueue<>(String::compareTo);
        visited = new boolean[brackets.size()];
        //powerset
        powerSet(0, brackets.size());
        //정렬
        que.poll();
        Set<String> check = new HashSet<>();
        while (!que.isEmpty()) {
            //중복삭제
            if(check.contains(que.peek())){
                que.poll();
            }else{
                check.add(que.peek());
                System.out.println(que.poll());

            }
        }
    }

    private static void powerSet(int cnt, int target) {
        if (cnt == target) {
            cal();
            return;
        }
        visited[cnt] = true;
        powerSet(cnt + 1, target);
        visited[cnt] = false;
        powerSet(cnt + 1, target);
    }

    private static void cal() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                set.add(brackets.get(i)[0]);
                set.add(brackets.get(i)[1]);
            }
        }
        //괄호 제거
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if(set.contains(i))continue;
            sb.append(str[i]);
        }
        que.add(sb.toString());
    }
}
