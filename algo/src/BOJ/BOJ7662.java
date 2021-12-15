package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7662 {//풀이중
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T =Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            int command = Integer.parseInt(br.readLine());
            for (int j = 0; j < command; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char ch = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());
                switch (ch){
                    case 'I':
                        arr.add(num);
                        arr.sort((o1, o2) -> o1-o2);
                        break;
                    case 'D':
                        if(arr.isEmpty())break;
                        if(num==-1){
                            arr.remove(0);
                        }else{
                           arr.remove(arr.size()-1);
                        }
                        break;
                }

            }
            if(arr.isEmpty()){
                System.out.println("EMPTY");
            }else {
                System.out.println(arr.get(arr.size()-1)+" "+arr.get(0));
            }
        }
    }
}
