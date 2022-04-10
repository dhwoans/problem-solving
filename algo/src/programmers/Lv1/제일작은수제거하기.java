package programmers.Lv1;

public class 제일작은수제거하기 {
    public int[] solution(int[] arr) {
        //빈 배열일 경우
        if(arr.length==1){
            return new int[]{-1};
        }
        int[] answer = new int[arr.length-1];
        int min = Integer.MAX_VALUE;
        for (int i : arr) {
            min = Math.min(i,min);
        }
        System.out.println(min);
        int index =0;
        for (int i : arr) {
            if(i==min)continue;
            answer[index++]=i;
        }
        return answer;
    }
}
