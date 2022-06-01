package Leetcode.easy;

import java.util.HashMap;

public class SingleRowKeyboard {
    public int calculateTime(String keyboard, String word) {
        char point = keyboard.charAt(0);
        int answer =0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i),i);
        }

        for (int i = 0; i < word.length(); i++) {
            answer+=Math.abs(map.get(point)-map.get(word.charAt(i)));
            point=word.charAt(i);
        }
        return answer;
    }
}