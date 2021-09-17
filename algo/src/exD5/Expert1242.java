package exD5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Expert1242 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int value = 0;
        for (int test_case = 1; test_case <= T; test_case++) {
            ArrayList<String> arr = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int i = 0; i < r; i++) {
                String str = br.readLine();

                str = str.replace("0", "");
                if (!str.equals("")) {
                    if (!arr.isEmpty() && arr.get(count - 1).equals(str)) {
                        continue;
                    } else {
                        arr.add(str);
                        count++;
                    }


                }

            }

        //16진수 코드 해독
        ArrayList<String> arr2 = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            String str2 = arr.get(i);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str2.length(); j++) {
                switch (str2.charAt(j)) {
                    case '0':
                        sb.append("0000");
                        break;
                    case '1':
                        sb.append("0001");
                        break;
                    case '2':
                        sb.append("0010");
                        break;
                    case '3':
                        sb.append("0011");
                        break;
                    case '4':
                        sb.append("0100");
                        break;
                    case '5':
                        sb.append("0101");
                        break;
                    case '6':
                        sb.append("0110");
                        break;
                    case '7':
                        sb.append("0111");
                        break;
                    case '8':
                        sb.append("1000");
                        break;
                    case '9':
                        sb.append("1001");
                        break;
                    case 'A':
                        sb.append("1010");
                        break;
                    case 'B':
                        sb.append("1011");
                        break;
                    case 'C':
                        sb.append("1100");
                        break;
                    case 'D':
                        sb.append("1101");
                        break;
                    case 'E':
                        sb.append("1110");
                        break;
                    case 'F':
                        sb.append("1111");
                        break;

                }

            }
        arr2.add(sb.toString());
        }

        //2진수 암호 해독
        ArrayList<Integer> integers = new ArrayList<>();
        String[] arr3 = {"3211", "2221", "2122", "1411", "1132", "1231", "1114", "1312", "1213", "3112"};
        new ArrayList<Integer>();
        for (int i = 0; i < arr2.size(); i++) {

            String str3 = arr2.get(i);
            int ratios = str3.length() / 56;

            for (int j = 0; j < str3.length(); j += 7 * ratios) {
                String part = str3.substring(j, j + 7 * ratios);
                int count2 = 0;
                int flag = 0;
                StringBuilder sb2 = new StringBuilder();
                //비율 알아보기
                for (int z = 0; z < 7 * ratios; z++) {
                    if (str3.charAt(z) == flag) {
                        count2++;

                    } else {
                        sb2.append(count2 / ratios);
                        count2 = 1;
                        if (flag == 0) {
                            flag = 1;
                        } else {
                            flag = 0;
                        }

                    }
                    if (z == 7 * ratios - 1) {
                        sb2.append(count2 / ratios);
                    }

                }
                integers.add(Arrays.asList(arr3).indexOf(sb2));

            }

        }
        //해독하기
        int x = 0;
        for (int i = 0; i < integers.size(); i++) {
            int even = 0;
            int odd = 0;

            int answer = 0;
            if (i == 7 + 8 * x) {
                x++;
                answer = odd * 3 + even + integers.get(i);
                if (answer % 10 == 0) {
                    value += integers.get(i);
                }
            }
            if (i % 2 == 1) {
                odd += integers.get(i);
            } else
                even += integers.get(i);
            for (int j = 0; j < 8; j++) {

            }
        }
        System.out.println("#" + test_case + " " + value);
    }
}
}
