package programmers.Lv1;


import java.util.ArrayList;
import java.util.Arrays;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] a = new int[answers.length];
        int[] b = new int[answers.length];
        int[] c = new int[answers.length];
        int[] copy = {3,3,1,1,2,2,4,4,5,5};
        int num = 1;
        for (int i = 0; i < answers.length; i++) {
            if (num > 5) num = 1;
            a[i] = num++;
        }
        num = 1;
        for (int i = 0; i < answers.length; i++) {
            if (i % 2 == 0){
                b[i] = 2;
                continue;
            } else {
                if (num == 2) {
                    num=3;
                    b[i]=num++;
                    continue;
                }
            }
            if(num>5)num=1;
            b[i]=num++;

        }
        num=0;
        for (int i = 0; i < answers.length; i++) {
            if(num>copy.length-1)num=0;
            c[i]=copy[num++];
        }
        //비교
        int[] count = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if(a[i]==answers[i])count[0]++;
            if(b[i]==answers[i])count[1]++;
            if(c[i]==answers[i])count[2]++;
        }
        int value =0;
        for (int i : count) {
            value = Math.max(value, i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if(value==count[i])ans.add(i+1);
        }
        int[] answer = new int[ans.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i]=ans.get(i);
        }
        return answer;
    }
}

