package BOJ.Bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        //입력받기
        int[] arr = new int[14];
        for (int i = 0; i < arr.length; i++) {
            int day = Integer.parseInt(st.nextToken());
            arr[i] = day;
        }
        //BNP
        Man bnp = new Man(money,0);
        //33
        Man ss = new Man(money,0);

        int up =0;
        int down =0;
        for (int i = 0; i < arr.length; i++) {
            if (bnp.cash >= arr[i]) {
                bnp.stock += bnp.cash/ arr[i];
                bnp.cash %= arr[i];

            }
            if(i<arr.length-1){
                if(arr[i]<arr[i+1]){
                    up++;
                    down=0;
                }else if(arr[i]>arr[i+1]){
                    down++;
                    up=0;
                }
            }
            if(down==3){
                ss.stock += ss.cash/arr[i];
                ss.stock %= arr[i];
                down=0;
            }
            if(up==3){
                ss.cash = ss.stock*arr[i];
                ss.stock=0;
                up=0;
            }
        }
        int a =bnp.total(arr[arr.length-1]);
        int b =ss.total(arr[arr.length-1]);

        if(a>b){
            System.out.println("BNP");
        }else if(a<b){
            System.out.println("TIMING");
        }else{
            System.out.println("SAMESAME");
        }

    }
}

class Man {
    int cash;
    int stock;

    Man(int cash,int stock) {
        this.cash = cash;
        this.stock = stock;
    }
    public int total(int num){

        return cash + (stock*num);
    }
    @Override
    public String toString() {
        return "Man{" +
                "cash=" + cash +
                ", stock=" + stock +
                '}';
    }
}
