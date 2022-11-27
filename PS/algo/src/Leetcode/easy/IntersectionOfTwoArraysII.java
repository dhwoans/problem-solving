package Leetcode.easy;


import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        //배열 map에 넣기
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        //나머지로 배열 조회
        for (int i : nums2) {
            if(map.containsKey(i)){
                if(map.get(i)>0){
                    list.add(i);
                    map.put(i,map.get(i)-1);
                }
            }
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i]=list.get(i);
        }
        return answer;
    }
}

