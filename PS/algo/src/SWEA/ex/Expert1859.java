package SWEA.ex;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 50
 * 5902 5728 8537 3857 739 6918 9211 9679 8506 3340
 * 6568 1868 16 7940 6263 4593 1449 6991 310 3355
 * 7068 1431 8580 1757 9218 4934 4328 3676 9355
 * 6221 9080 5922 1545 8511 4067 5467 8674 4691
 * 6504 9835 2034 4965 9980 1221 5895 2501 8152 8325 7731 9302
 */
public class Expert1859 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("C:\\ALGO\\algo\\src\\input\\input1859.txt"));


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int days = Integer.parseInt(br.readLine());
            ArrayList<Integer> arr = new ArrayList<>();
            //배열에 담기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < days; i++) {
                arr.add(Integer.parseInt(st.nextToken()));

            }
            int max = 0;
            int sell = 0;
            int ben = 0;

            int start =0;
            out:
            while (start!=days-1) {
                max = 0;


                //최대값을 찾는다
                for (int i = start; i < arr.size(); i++) {
                    if (arr.get(i)>max) {
                        max=arr.get(i);
                        sell = i;

                    }

                }

                if(arr.get(start)==max){
                    for (; start < arr.size()-1 ; start++) {

                        if(arr.get(start)<arr.get(start+1)){
                            break;

                        }
                    }



                }else {
                    for (int i = start; i < sell; i++) {
                        ben+=max-arr.get(i);
                    }

                    start =sell+1;
                    if(start==arr.size())break;
                }

            }
            System.out.printf("#%d %d\n", test_case, ben);
        }
    }
}