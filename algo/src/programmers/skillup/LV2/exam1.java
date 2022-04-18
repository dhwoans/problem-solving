package programmers.skillup.LV2;







import java.util.HashMap;



public class exam1 {
    public int[] solution(int n, String[] words) {
        int[] answer = {0,0};
        HashMap<String, Integer> map = new HashMap<>();
        char end =' ';
        //맵에 담기
        for (int i = 0; i < words.length; i++) {
            //끝자 확인
            if(i>=1){
                if(end!=words[i].charAt(0)){
                    System.out.println("철자틀림");
                    answer[0]=(i%n)+1;
                    answer[1]=(i/n)+1;
                    return answer;
                }
            }
            //중복확인
            if(!map.containsKey(words[i])){
                map.put(words[i],0);
            }else{
                answer[0]=(i%n)+1;
                answer[1]=(i/n)+1;
                return answer;
            }
            end = words[i].charAt(words[i].length()-1);

        }

        return answer;
    }
}