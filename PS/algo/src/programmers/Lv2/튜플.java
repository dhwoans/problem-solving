package programmers.Lv2;

import java.util.*;

//"{{2},{2,1},{2,1,3},{2,1,3,4}}"
public class 튜플 {
    public int[] solution(String s) {
        ArrayList<int[]> list = new ArrayList<>();
        s = s.replace("},{","|")
                .replace("{{","")
                .replace("}}","")
                .replace(","," ")
                .replace("|",",");

        String[] arr = Arrays.stream(s.split(",")).sorted((o1, o2) -> {
            return o1.length()-o2.length();
        }).toArray(String[]::new);

        for (String s1 : arr) {
            list.add(Arrays.stream(s1.split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        int[] answer = new int[list.size()];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).length; j++) {
                if(!set.contains(list.get(i)[j])){
                    set.add(list.get(i)[j]);
                    answer[i]=list.get(i)[j];
                }
            }
        }
        return answer;
    }
}
