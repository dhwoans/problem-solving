package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int T,max,min;
    static Stack<Integer> stack;
    static int[] num;
    static int[] temp;
    static boolean[] visit;
    static char[] sign;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        T =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        visit = new boolean[T-1];
        arr=new char[T-1];
        stack = new Stack();
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        //숫자넣기
        num = new int[T];
        for (int i = 0; i < num.length; i++) {
            num[i]=Integer.parseInt(st.nextToken());
        }
        //부호넣기
        st= new StringTokenizer(br.readLine());
        temp = new int[4];
        for (int i = 0; i < temp.length; i++) {
            temp[i]=Integer.parseInt(st.nextToken());
        }
        //부호 구체화
        sign = new char[T-1];
        int z = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i]; j++) {

                if(i==0){sign[z++]='+'; }
                if(i==1){sign[z++]='-'; }
                if(i==2){sign[z++]='*'; }
                if(i==3){sign[z++]='/'; }

            }
        }
        DFS(0);
        System.out.println(max);
        System.out.println(min);
    }

    static void DFS(int cnt){
        if(cnt == T-1){
            cal();
            return;
        }
        for (int i = 0; i < T-1; i++) {
            if(visit[i])continue;
            visit[i]=true;
            arr[cnt]=sign[i];
            DFS(cnt+1);
            visit[i]=false;
        }
    }

    static void cal(){
        for (int i = num.length-1; i >= 0; i--) {
            stack.push(num[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            int num1 =0;
            int num2 =0;
           switch (arr[i]){
               case '+':
                   num1= stack.pop();
                   num2= stack.pop();

                   stack.push(num1+num2);
                   break;
               case '-':
                   num1= stack.pop();
                   num2= stack.pop();

                   stack.push(num1-num2);
                   break;
               case '*':
                   num1= stack.pop();
                   num2= stack.pop();

                   stack.push(num1*num2);
                   break;
               case '/':
                   num1= stack.pop();
                   num2= stack.pop();

                   stack.push(num1/num2);
                   break;
           }
        }
        max = Math.max(max, stack.peek());
        min = Math.min(min, stack.peek());
        stack.clear();
    }
}
