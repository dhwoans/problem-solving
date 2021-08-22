package exD3;

public class Expert1217 {
    public static void main(String[] args) {
        System.out.println(power(2,5));
    }
    static int power(int n,int m){
        if(m==1) return n;
        return n*power(n,m-1);
    }
}
