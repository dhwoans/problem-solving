package BOJ;

public class WS2 {
    public static void main(String[] args) {
        final int N = 5;
        int emptyCnt = 0, num = 0;
        for (int i = 0; i < N; i++) {
            // 공백 출력
            if (emptyCnt != 0) {
                System.out.printf("%" + emptyCnt * 3 + "s", " ");
            }
            // 숫자 출력
            for (int j = 0; j < N - emptyCnt * 2; j++) {
                System.out.printf("%3d", ++num);
            }

            System.out.println();

            // 공백 카운드의 증가와 감소
            if (i < N/2) emptyCnt++;
            else emptyCnt--;
        }
    }
}
