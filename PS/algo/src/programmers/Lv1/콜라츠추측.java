package programmers.Lv1;

public class 콜라츠추측 {
    public int solution(int num) {
        int answer = 0;
        while (answer!=501){
            if(num==1)break;
            if(num%2==0){
                num=num/2;
            }else{
                num=(num*3)+1;
            }
            answer++;
        }
        if(answer==501)answer=-1;
        return answer;
    }
}

