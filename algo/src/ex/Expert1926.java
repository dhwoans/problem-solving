package ex;

import java.util.Scanner;

public class Expert1926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =sc.nextInt();
        for(int i=1;i<=N;i++){
            String num = Integer.toString(i);

            if(num.contains("3")||num.contains("6")||num.contains("9")){
                for(int j=0;j<num.length();j++){
                    if(num.charAt(j)=='3'||num.charAt(j)=='6'||num.charAt(j)=='9'){
                        System.out.print("-");
                    }else{
                        System.out.print("");
                    }

                }
                System.out.print(" ");
            }else{
                System.out.print(num+" ");
            }

        }
    }
}
