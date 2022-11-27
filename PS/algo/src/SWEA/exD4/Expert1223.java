package SWEA.exD4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 각 테스트 케이스의 첫 번째 줄에는 테스트 케이스의 길이가 주어진다. 그 다음 줄에 바로 테스트 케이스가 주어진다.
 * <p>
 * 총 10개의 테스트 케이스가 주어진다.
 */
public class Expert1223 {
    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input1223.txt"));
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int num = sc.nextInt();
            //배열에 담기
            char[] chars = new char[num];
            String str = sc.next();
            for (int i = 0; i < num; i++) {
                chars[i] = str.charAt(i);

            }
            //후위식으로변환
            Stack<Character> cal = new Stack<>();
            ArrayList<Character> postorder = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= '0' && chars[i] <= '9') {
                    postorder.add(chars[i]);
                } else {
                    switch (chars[i]) {
                        case '+':
                            if (cal.isEmpty()) {
                                cal.push(chars[i]);
                            } else {
                                while (!cal.isEmpty()) {
                                    postorder.add(cal.pop());
                                }
                                cal.push(chars[i]);
                            }
                            break;
                        case '*':
                            while (!cal.isEmpty()&&cal.peek() == '*') {
                                postorder.add(cal.pop());

                            }
                            cal.push(chars[i]);
                            break;
                    }
                }
            }
            while (!cal.isEmpty()){
                postorder.add(cal.pop());
            }
            //후위식 계산
            Stack<Integer> n = new Stack<>();
            for (int i = 0; i < postorder.size(); i++) {
                if (postorder.get(i) >= '0' && postorder.get(i) <= '9') {
                    n.push(postorder.get(i) - '0');
                } else {
                    switch (postorder.get(i)) {
                        case '+':
                            int sum = n.pop() + n.pop();
                            n.push(sum);
                            break;
                        case '*':
                            int mul = n.pop() * n.pop();
                            n.push(mul);
                            break;
                    }

                }
            }
            System.out.printf("#%d %d",test_case,n.pop());
        }

    }
}
