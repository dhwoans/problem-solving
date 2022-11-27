package programmers.Lv2;


import java.util.Arrays;

public class 줄서는방법 {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        for (int i = 1; i < n+1; i++) {
            answer[i-1]  = i;
        }
        for (int i = 0; i < k; i++) { //k번반복
            int point1 = 0;
            int point2 = 0;
            int point3 = 0;
            //1단계
            for (int j = 0; j < n-1; j++) {
                if(answer[j]<answer[j+1]){
                   point1=j;
                   point2=j+1;
                }
            }
            //2단계
            for (int j = point1; j < n; j++) {
                if(answer[point1]<answer[j]){
                    point3 = j;
                }
            }
            move(answer,point1,point3);
            //3단계
            int j = n-1;
            while (point2<j){
                move(answer,point2,j);
                point2++;
                j--;
            }
            System.out.println(Arrays.toString(answer));
        }
        return answer;
    }

    private void move(int[] answer,int i,int j) {
            int temp = answer[i];
            answer[i]= answer[j];
            answer[j]= temp;
    }
}
