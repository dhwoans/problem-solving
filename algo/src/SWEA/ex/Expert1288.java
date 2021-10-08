package SWEA.ex;

import java.util.Scanner;

public class Expert1288 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data ="5\n" +
                "1\n" +
                "2\n" +
                "11\n" +
                "1295\n" +
                "1692";


        sc = new Scanner(data);
        int t=sc.nextInt();

        //테스트 케이스 만큼 반복
        for(int i=0;i<t;i++){
            //넘버 값받기
            boolean flag=true;
            int num=sc.nextInt();
            int count=1;
            int num2= num;

            //0~9카운트할 배열 만들기
            int arr[]=new int[10];
            while(flag){

            //넘버 분해하기
            while (num2>0){
                arr[num2%10]++;
                num2/=10;
            }
            //arr 값이 다 1인지 확인
            for(int j=0;j<arr.length;j++){
                    //0이 나오면 num 배수 올리기
                    if(arr[j]==0){
                        count++;
                        num2=num*count;
                        flag=true;
                        break;
                    }else if(arr[j]>=1){//1이 다채워졌으면 루프 탈출
                        flag=false;
                    }

                }




            }

            System.out.println(num*count);
        }
        }

    }

