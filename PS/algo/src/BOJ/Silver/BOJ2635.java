package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;


public class BOJ2635 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        int max =0;
        for (int i = n; i >= 0 ; i--) {
            arr.add(n);
            arr.add(i);
            int temp =0;
            int count =0;
            while(temp>=0){
                temp = arr.get(count)-arr.get(count+1);
                arr.add(temp);
                count++;
            }
            if(max<arr.size()-1){
                max =arr.size()-1;
                answer = arr;
            }
            arr = new ArrayList<>();
        }
        System.out.println(max);
        answer.stream().filter(it->it>-1).forEach(it-> System.out.print(it+" "));
    }
}
