package Leetcode.easy;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;

/**
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class Roman_to_Integer {
    static int check(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'I':
                    num += 1;
                    break;
                case 'V':
                    if(i>0&&s.charAt(i-1)=='I'){
                        num+=-2;
                    }
                    num += 5;
                    break;
                case 'X':
                    if(i>0&&s.charAt(i-1)=='I'){
                        num+=-2;
                    }
                    num += 10;
                    break;
                case 'L':
                    if(i>0&&s.charAt(i-1)=='X'){
                        num+=-20;
                    }
                    num += 50;
                    break;
                case 'C':
                    if(i>0&&s.charAt(i-1)=='X'){
                        num+=-20;
                    }
                    num += 100;
                    break;
                case 'D':
                    if(i>0&&s.charAt(i-1)=='C'){
                        num+=-200;
                    }
                    num += 500;
                    break;
                case 'M':
                    if(i>0&&s.charAt(i-1)=='C'){
                        num+=-200;
                    }
                    num += 1000;
                    break;

            }
        }
        return num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int answer = check(str);
        System.out.println(answer);
    }
}
