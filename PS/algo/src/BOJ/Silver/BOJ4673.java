package BOJ.Silver;

public class BOJ4673 {

    static boolean[] visited;

    public static void main(String[] args) {
        visited = new boolean[10001];

        for (int i = 1; i < visited.length; i++) {
            d(i);
        }
        for (int i = 1; i < visited.length; i++) {
            if(!visited[i]) System.out.println(i);

        }
    }

    private static void d(int i) {
        int sum = i;
        while (i>0){
            sum += i%10;
            if(sum>10000)return;
            i/=10;
        }
        visited[sum]=true;
    }
}
