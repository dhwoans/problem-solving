package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ15658 {//풀이중- 시간초과
    static int T,max,min;
    static Stack stack;
    static int[] num;
    static int[] temp;
    static boolean[] visit;
    static char[] sign;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        T =Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

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
        int sum =0;
        for (int i = 0; i < temp.length; i++) {
            temp[i]=Integer.parseInt(st.nextToken());
            sum+=temp[i];
        }
        //부호 구체화
        sign = new char[sum];
        visit = new boolean[sum];
        int z = 0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i]; j++) {

                if(i==0){sign[z++]='+'; }
                if(i==1){sign[z++]='-'; }
                if(i==2){sign[z++]='*'; }
                if(i==3){sign[z++]='/'; }



            }
        }
        DFS(0,num[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void DFS(int cnt,int sum){
        if(cnt == T-1){
            max=Math.max(sum,max);
            min=Math.min(sum,min);
            return;
        }
        for (int i = 0; i < sign.length; i++) {
            if(visit[i])continue;
            visit[i]=true;
            sum=cal(sign[i],cnt,sum);
            DFS(cnt+1,sum);
            visit[i]=false;
            if(sign[i]=='+'){
                sum=cal('-',cnt,sum);
            }else if(sign[i]=='-'){
                sum=cal('+',cnt,sum);
            }else if(sign[i]=='*'){
                sum=cal('/',cnt,sum);
            }else if(sign[i]=='/'){
                sum=cal('*',cnt,sum);
            }
        }
    }

    static int cal(char ch,int cnt,int sum){
            int temp=0;
            switch (ch){
                case '+':
                    temp= sum+num[cnt+1];
                    break;
                case '-':
                    temp= sum-num[cnt+1];
                    break;
                case '*':
                    temp= sum*num[cnt+1];
                    break;
                case '/':
                    temp= sum/num[cnt+1];
                    break;
            }
            return temp;
        }


}
