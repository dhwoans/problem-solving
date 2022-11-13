package BOJ.Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.abs;


public class BOJ2938 {

    private static ArrayList<Integer> zero;
    private static ArrayList<Integer> one;
    private static ArrayList<Integer> two;
    private static int[] ans;
    private static boolean flag =false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        var n = Integer.parseInt(br.readLine());
        var arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ans = new int[n];

        zero = new ArrayList<Integer>();
        one = new ArrayList<Integer>();
        two = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            switch(arr[i]%3){
                case 0 :
                    zero.add(arr[i]);
                    break;
                case 1 :
                    one.add(arr[i]);
                    break;
                case 2 :
                    two.add(arr[i]);
                    break;
            }
        }
        dfs(0,arr.length,0,0,0,0);
        if(flag){
            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i]+" ");
            }
        }else{
            System.out.println(-1);
        }

    }

    private static void dfs(int cnt,int target,int zeroindx,int oneindx, int twoindx,int pre) {
        if(cnt==target){
            flag = true;
            return;
        }
        if(flag) return;
        if(cnt==0){
            if(!flag &&zeroindx<zero.size()){
                ans[cnt]=zero.get(zeroindx);
                dfs(cnt+1,target,zeroindx+1,oneindx,twoindx,0);
            }
            if(!flag &&oneindx<one.size()){
                ans[cnt]=one.get(oneindx);
                dfs(cnt+1,target,zeroindx,oneindx+1,twoindx,1);
            }
            if(!flag && twoindx<two.size()){
                ans[cnt]=two.get(twoindx);
                dfs(cnt+1,target,zeroindx,oneindx,twoindx+1,2);
            }
        }else{
            if(pre==0){
                if(!flag &&oneindx<one.size()){
                    ans[cnt]=one.get(oneindx);
                    dfs(cnt+1,target,zeroindx,oneindx+1,twoindx,1);
                }
                if(!flag &&twoindx<two.size()){
                    ans[cnt]=two.get(twoindx);
                    dfs(cnt+1,target,zeroindx,oneindx,twoindx+1,2);
                }
            }else if(pre==1||pre==2){
                if(!flag &&zeroindx<zero.size()){
                    ans[cnt]=zero.get(zeroindx);
                    dfs(cnt+1,target,zeroindx+1,oneindx,twoindx,0);
                }
                if(pre==1){
                    if(!flag &&oneindx<one.size()){
                        ans[cnt]=one.get(oneindx);
                        dfs(cnt+1,target,zeroindx,oneindx+1,twoindx,1);
                    }
                }else {
                    if(!flag &&twoindx<two.size()){
                        ans[cnt]=two.get(twoindx);
                        dfs(cnt+1,target,zeroindx,oneindx,twoindx+1,2);
                    }
                }
            }
        }
    }
}
