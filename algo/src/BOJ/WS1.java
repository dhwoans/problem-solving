package BOJ;

public class WS1 {
    public static void main(String[] args) {
        int num=1;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(i>j){
                    System.out.printf(" \t");
                }else{
                    System.out.printf("%d\t",num++);
                }
            }
            System.out.println();
        }
    }
}
