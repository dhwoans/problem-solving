package SWEA.ex;

import java.util.Scanner;

public class Expert1976 {
    public static void main(String[] args) {
        String data ="3 \n" +
                "3 17 1 39\n" +
                "8 22 5 10\n" +
                "6 53 2 12";
        Scanner sc = new Scanner(System.in);
        sc= new Scanner(data);
        int T =sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            int hour =sc.nextInt();
            int min = sc.nextInt();
            hour += sc.nextInt();
            min += sc.nextInt();

            if(min>=60){
                min-=60;
                hour+=1;
            }
            if(hour>=12){
                hour-=12;
            }
            System.out.println("#"+test_case+" "+hour+" "+min);
        }
    }
}
