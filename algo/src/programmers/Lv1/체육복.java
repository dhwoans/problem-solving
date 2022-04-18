package programmers.Lv1;

import java.util.Arrays;


public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        int answer = 0;
        boolean[] student = new boolean[n+1]; //1부터 시작
        boolean[] check = new boolean[n+1]; //여벌티 가지고 있는지
        //도둑든 사람 표시
        for (int i : lost) {
            student[i] = true;
        }
        //여벌티 가지고 있는지
        for (int i : reserve) {
            check[i]=true;
        }
        // 여벌티 가지고 있고 도둑 맞았는지
        for (int i = 1; i < check.length; i++) {
            if(check[i]){
                if(student[i]){
                    System.out.println(i);
                    check[i]=false;
                    student[i]=false;

                }
            }
        }
        //나보다 큰사람 빌려줄수 있는지
        int count = 0;
        for (int i = 0; i < reserve.length; i++) {
            if(!check[reserve[i]])continue;
            if (reserve[i]+1 >= student.length) continue;
            if (student[reserve[i]+1]) {
                check[reserve[i]] = false;
                student[reserve[i]+1] = false;
            }
        }


        //나보다 작은 사람 빌려줄수 있는지
        for (int i = reserve.length - 1; i >= 0; i--) {
            if(!check[reserve[i]])continue;
            if (reserve[i] - 1 <= 0) continue;
            if (student[reserve[i] - 1]) {
                student[reserve[i] - 1] = false;
            }
        }

        //숫자세기
        for (boolean b : student) {
            if (!b) answer++;
        }
        return answer-1;
    }
}
