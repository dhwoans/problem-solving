package Leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PushDominoes {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder();
        int[] R = new int[dominoes.length()];
        int[] L = new int[dominoes.length()];
        int force = 0;
        for (int i = 0; i < dominoes.length(); i++) {
            if(dominoes.charAt(i)=='R') force = dominoes.length();
            else if(dominoes.charAt(i)=='L') force =0;
            R[i]=force;
            if(force>0)force--;
        }
        force = 0;

        for (int i = dominoes.length()-1; i >= 0; i--) {
            if(dominoes.charAt(i)=='L') force = -dominoes.length();
            else if(dominoes.charAt(i)=='R') force =0;
            L[i]=force;
            if(force<0)force++;
        }
        for (int i = 0; i < R.length; i++) {
            if(R[i]+L[i]>0)sb.append("R");
            else if(R[i]+L[i]<0)sb.append("L");
            else if(R[i]+L[i]==0)sb.append(".");
        }
        return sb.toString();
    }
}
