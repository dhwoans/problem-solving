package BOJ;

public class stemp {
    public static void main(String[] args) {
        int n =5;
        int num =0;
        for(int i=0,j=0;i<n;i++){
            for(int k=0;k<(n-j);k++){
                System.out.printf("%s\t",(k<j)?" ":++num);
            }
            if(i<n/2){
                j++;
            }else{
                j--;
            }
            System.out.println();
        }
    }
}
