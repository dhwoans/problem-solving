package SWEA.exD3;

import java.util.Scanner;

public class Expert4406 {
    public static void main(String[] args) {
        String data = "3\n" +
                "congratulation\n" +
                "synthetic\n" +
                "fluid";
        Scanner sc = new Scanner(System.in);
        sc= new Scanner(data);

        int T = sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            String str = sc.next();
            System.out.printf("#%d ",test_case);
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'){
                    continue;
                }
                System.out.print(str.charAt(i));

            }
            System.out.println();
            }
        }
    }

