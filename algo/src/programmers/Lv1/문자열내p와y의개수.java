package programmers.Lv1;


import java.util.Locale;

public class 문자열내p와y의개수 {
    boolean solution(String s) {
        var p =0;
        var y =0;
        for (char c : s.toLowerCase(Locale.ROOT).toCharArray()) {
            if(c=='p')p++;
            else if(c=='y')y++;
        }
        if(p==y) return true;
        else return false;
    }
}
