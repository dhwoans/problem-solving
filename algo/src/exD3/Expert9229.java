package exD3;


import java.util.Scanner;

public class Expert9229 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data ="4\n" +
                "3 45\n" +
                "20 20 20\n" +
                "6 10\n" +
                "1 2 5 8 9 11\n" +
                "4 100\n" +
                "80 80 60 60\n" +
                "4 20\n" +
                "10 5 10 16\n";
        sc =new Scanner(data);
        int T =sc.nextInt();
        for(int test_case=1;test_case<=T;test_case++){
            int size =sc.nextInt();
            int limit =sc.nextInt();
            int answer=-1;
            int[] arr = new int[size];
            for(int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }
            for(int z=0;z<arr.length-1;z++){
                for(int a=z+1;a<arr.length;a++){
                    if(arr[z]+arr[a]<=limit){
                        answer=Math.max(answer,arr[z]+arr[a]);
                    }


                }
            }
            System.out.printf("#%d %d\n",test_case,answer);

        }
    }

}
