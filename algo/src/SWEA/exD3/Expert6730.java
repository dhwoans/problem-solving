package SWEA.exD3;

import java.util.Scanner;

public class Expert6730 {
    public static void main(String[] args) {
        String data = "5\n" +
                "5\n" +
                "10 70 30 50 90\n" +
                "2\n" +
                "30 100\n" +
                "2\n" +
                "100 20\n" +
                "3\n" +
                "40 40 40\n" +
                "7\n" +
                "12 345 678 901 23 45 6\n" +
                "\n";
        Scanner sc = new Scanner(System.in);
        sc=new Scanner(data);
        int T =sc.nextInt();
        for(int test_case =1;test_case<=T;test_case++){
            int size = sc.nextInt();
            int arr[] = new int[size];
            for(int z=0;z<arr.length;z++){
                arr[z]=sc.nextInt();
            }
            //뺴기
            int min = 0;
            int max = 0;
            int result =0;
            for(int x=0;x<arr.length-1;x++){
                result = arr[x]-arr[x+1];
                if(result>0){
                    max= Math.max(max,result);
                }else{
                    min= Math.max(min, Math.abs(result));
                }
            }
            System.out.println("#"+test_case+" "+Math.abs(min)+" "+max);

        }

    }
}
