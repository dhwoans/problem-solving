package programmers.Lv1;

public class 약수의개수와덧셈 {
    public int solution(int left, int right) {
        int answer = 0;
        //left 에서 right 까지
        for (int i = left; i <= right; i++) {
            if(divisorisOdd(i)){
                answer -=i;
            }else{
                answer +=i;
            }
        }
        return answer;
    }

    private boolean divisorisOdd(int i) {
        int count =0;
        boolean flag = true;
        for (int j = 1; j <= i; j++) {
            if(i/j==0){

                count++;
            }
        }
        if(count%2==0){
            return false;
        }
        return true;
    }
}