package programmers.Lv1;

public class 하샤드수 {
    public boolean solution(int x) {
        int original =x;
        int sum =0;
        boolean answer = true;
        while(x!=0){
            sum+=(x%10);
            x/=10;
        }
        System.out.println(sum);
        if(original%sum!=0){
            answer=false;
        }
        return answer;
    }
}
