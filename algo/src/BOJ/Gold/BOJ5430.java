package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 1316.그룹 단어 체커
 *
 * io가 까다롭다
 *
 * 요구사항 꼼꼼히 살피자자
*/
public class BOJ5430 {
    static Deque<Integer> dq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        out:for (int i = 0; i < T; i++) {

            String command = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            dq = new LinkedList();
            toarray(arr, len);
            boolean flag = true;
            for (int j = 0; j < command.length(); j++) {
                char c = command.charAt(j);
                switch (c) {
                    case 'R':
                        if (flag) {
                            flag = false;
                        } else {
                            flag = true;
                        }
                        break;
                    case 'D':
                        if (dq.isEmpty()) {
                            System.out.println("error");
                            continue out;
                        }
                        if (flag) {
                            dq.pollFirst();
                        } else {
                            dq.pollLast();
                        }
                        break;
                }
            }
            //출력
            StringBuilder sb = new StringBuilder();
                if(dq.isEmpty()){
                    System.out.println("[]");
                    continue;
                }
                if (flag) {
                    sb.append("[").append(dq.pollFirst());
                    while (!dq.isEmpty()) {
                        sb.append(",").append(dq.pollFirst());
                    }
                    sb.append("]");
                } else {
                    sb.append("[").append(dq.pollLast());
                    while (!dq.isEmpty()) {
                        sb.append(",").append(dq.pollLast());
                    }
                    sb.append("]");
                }

            System.out.println(sb);
            }
        }


    static void toarray(String s, int len) {
        s=s.replace("[", "");
        s=s.replace("]", "");
        s=s.replace(",", " ");
        StringTokenizer st = new StringTokenizer(s);
        for (int i = 0; i < len; i++) {
            int num = Integer.parseInt(st.nextToken());
            dq.addLast(num);
        }

    }
}

