package SWEA.ex;

import java.util.Scanner;

public class Expert1948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();

        for(int i = 1;i<=test_case;i++){
            int sum = 0;
            int[] mounth= new int[2];
            int[] day = new int[2];

            //배열에 담기
            for(int j=0;j<mounth.length;j++){

                mounth[j]=sc.nextInt();
                day[j]=sc.nextInt();
            }
            //값비교
            int end[] = {31,28,31,30,31,30,31,31,30,31,30,31};
            int startMon =mounth[0]-1;
            int endMon =mounth[1]-1;
            if(startMon==endMon){
                sum=day[1]-day[0]+1;
            }else {
                //월계산
                for (int x = startMon + 1; x < endMon; x++) {
                    sum += end[x];
                }
                int startday = end[startMon] - day[0];
                sum += startday + day[1] + 1;
            }

        System.out.printf("#%d %d\n",i,sum);
            }
        }
    }

