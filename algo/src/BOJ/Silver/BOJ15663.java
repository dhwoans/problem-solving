package BOJ.Silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class BOJ15663 {
    static int n,r;
    static int arr[];
    static int input[];
    static boolean isSelect[];
    static StringBuilder sb = new StringBuilder();
    private static HashMap<String, Boolean> map;
    private static ArrayList<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        r= Integer.parseInt(st.nextToken());
        arr = new int[r];
        input= new int[n];
        isSelect =new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            input[i]=Integer.parseInt(st.nextToken());
        }
        list = new ArrayList<String>();
        dfs(0,0);
        HashSet<String> set = new HashSet<>(list);
        List<String> answer = new ArrayList(set);
        ArrayList<String[]> result = new ArrayList<>();
        for (String o : answer) {
            String[] arr= o.split(" ");
            result.add(arr);
        }
        Collections.sort(result,(o1,o2)->{
            for (int i = 0; i < o1.length; i++) {
                if(o1[i].equals(o2[i]))continue;
                else return Integer.parseInt(o1[i])-Integer.parseInt(o2[i]);
            }
            return Integer.parseInt(o1[0])-Integer.parseInt(o2[0]);
        });
        for (String[] strings : result) {
            for (String string : strings) {
                System.out.print(string +" ");
            }
            System.out.println();
        }


    }
    static void dfs(int cnt,int num){
        if(cnt==r){
            String str= "";
           for(int i=0;i<arr.length;i++){

              str+=arr[i]+" ";
           }
           list.add(str);
            return;
        }

           for(int i=0;i<n;i++){
               if(isSelect[i])continue;
               if(num==input[i]){isSelect[i]=true;}
               arr[cnt]=input[i];
               isSelect[i]=true;
               dfs(cnt+1,arr[cnt]);
               isSelect[i]=false;
           }
        }
    }
