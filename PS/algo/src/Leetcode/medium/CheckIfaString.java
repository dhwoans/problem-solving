package Leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class CheckIfaString {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        boolean answer = false;
        for (int i = 0; i < s.length()-k+1; i++) {
            set.add(s.substring(i,i+k));
            System.out.println(s.substring(i,i+k));
        }
        if(set.size()==(int)Math.pow(2,k))answer=true;
        return answer;
    }
}
