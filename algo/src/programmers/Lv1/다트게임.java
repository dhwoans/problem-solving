package programmers.Lv1;

import java.util.ArrayList;

public class 다트게임 {
    public int solution(String dartResult) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            if(ch>='0'&&ch<='9'){ //점수일때
                if(ch=='1'&&dartResult.charAt(i + 1) == '0') {
                        arr.add(10);
                        i++;
                    } else {
                        arr.add(ch - '0');
                    }
            }else if(ch=='D'){ //보너스
                int temp = arr.get(arr.size()-1);
                arr.set(arr.size()-1,temp*temp);
            }else if(ch=='T'){
                int temp = arr.get(arr.size()-1);
                arr.set(arr.size()-1,temp*temp*temp);
            }else if(ch=='*'){
                int now = arr.get(arr.size()-1);
                arr.set(arr.size()-1,now*2);
                if(arr.size()!=1){
                    int pre = arr.get(arr.size()-2);
                    arr.set(arr.size()-2,pre*2);
                }
            }else if(ch=='#'){
                arr.set(arr.size()-1,arr.get(arr.size()-1)*-1);
            }
        }
        return arr.stream().reduce(Integer::sum).get();
    }
}
