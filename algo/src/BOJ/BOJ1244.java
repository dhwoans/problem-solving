package BOJ;

import java.util.Scanner;

public class BOJ1244 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String data = "8\n" +
//                "0 1 0 1 0 0 0 1\n" +
//                "2\n" +
//                "1 3\n" +
//                "2 3";
//
//
//
//        sc = new Scanner(data);
        int size = sc.nextInt();
        int arr[] = new int[size + 1];
        arr[0] = 9;
        //배열담기
        for (int i = 1; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int round = sc.nextInt();
        for (int z = 0; z < round; z++) {
            int gender = sc.nextInt();
            int num = sc.nextInt();
            switch (gender) {
                case 1:
                    for (int w = 0; w < arr.length; w += num) {
                        if (arr[w] == 0) {
                            arr[w] = 1;
                        } else if (arr[w] == 1) {
                            arr[w] = 0;
                        }
                    }
                    break;
                case 2:
                    boolean flag =true;
                    int a =1;
                    while(flag){
                        if(num-a<0||num+a>=arr.length){
                            for(int p=num-a+1;p<=num+a-1;p++){
                                if(arr[p]==1){
                                    arr[p]=0;
                                }else if(arr[p]==0){
                                    arr[p]=1;
                                }

                            }
                            flag=false;
                        }else if(arr[num-a]!=arr[num+a]){
                            for(int p=num-a+1;p<=num+a-1;p++){
                                if(arr[p]==1){
                                    arr[p]=0;
                                }else if(arr[p]==0){
                                    arr[p]=1;
                                }

                            }
                            flag=false;
                        }
                        a++;
                    }

            }
        }
            for (int x = 1; x < arr.length; x++) {

                System.out.printf("%d ", arr[x]);
                if (x % 20 == 0) {
                    System.out.println();

                }

            }
    }
}