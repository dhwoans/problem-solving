package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ16120 {

    private static Stack<Character> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='A'){
                //앞에 PP있는지 확인
                for (int j = 0; j < 2; j++) {
                    if(!check()){
                        System.out.println("NP");
                        return;
                    }
                }
                //뒤에 P가 있는지 확인
                if(i+1>=str.length()||str.charAt(i+1)!='P'){
                    System.out.println("NP");
                    return ;
                }else{
                    i++;
                }
                //P넣기
                stack.add('P');
            }else{
                stack.add(str.charAt(i));
            }
        }
        if(stack.size()==1&&stack.pop()=='P') System.out.println("PPAP");
        else System.out.println("NP");
    }

    private static boolean check() {
        if(stack.isEmpty())return false;
        if(stack.peek()!='P')return false;
        stack.pop();
        return true;
    }
}
