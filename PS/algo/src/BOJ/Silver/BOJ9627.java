package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ9627 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] one= {"","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] ten= {"ten","eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] twenty={"","","twenty", "thirty", "forty", "fifty", "sixty","seventy", "eighty", "ninety"};
        String[] hundred= {"","onehundred", "twohundred", "threehundred", "fourhundred", "fivehundred", "sixhundred", "sevenhundred", "eighthundred", "ninehundred"};

        int n = Integer.parseInt(br.readLine());
        String[] str = new String[n];
        int count = -1;
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
            count+=str[i].length();
        }
        int num =0;
        for (int i = 0; i < hundred.length; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < one.length; k++) {
                    if(i==0&&j==0&&k==0)continue;
                    num++;
                    String len ="";
                    if(j==1){
                        len = hundred[i]+ten[k];
                    }else{
                        len = hundred[i]+twenty[j]+one[k];
                    }

                    if(len.length()+count==num){
                        for (String s : str) {
                            if (s.equals("$")) {
                                System.out.print(len+" ");
                            } else {
                                System.out.print(s+" ");
                            }
                        }
                        return;
                    }

                }
            }
        }


    }
}
