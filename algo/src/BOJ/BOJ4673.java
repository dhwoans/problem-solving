package BOJ;

public class BOJ4673 {//풀이중
    public static void main(String[] args) {
        boolean[] arr = new boolean[20000];

        for (int i = 1; i <= 10000; i++) {
            int num =i;
            while(i/10!=0){

                num+=i%10;
                i/=10;
            }
            arr[num]=true;
        }
        for (int i = 1; i < arr.length; i++) {
            if(i>=10000)break;
            if(arr[i]==false){
                System.out.println(i);
            }
        }

    }
}
