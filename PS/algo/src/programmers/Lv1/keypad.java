package programmers.Lv1;

public class keypad {

    private int rightpos;
    private int leftpos;
    private int[][] map;

    public String solution(int[] numbers, String hand) {
        leftpos = 10;
        rightpos = 11;
        StringBuilder sb = new StringBuilder();
        //좌표값 저장
        map = new int[13][2];
        map[0]=new int[]{3,1};
        map[10] =new int[]{3,0}; //왼
        map[11] =new int[]{3,2}; //오
        int num =1 ;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[num++]=new int[]{i,j};
            }
        }
        for (int number : numbers) {
            switch (number) {
                case 1:
                case 4:
                case 7:
                    sb.append("L");
                    leftpos = number;
                    break;
                case 3:
                case 6:
                case 9:
                    sb.append("R");
                    rightpos = number;
                    break;

                case 2:
                case 5:
                case 8:
                case 0:
                    sb.append(cal(number, hand));

            }

        }

        return sb.toString();
    }

    private char cal(int number,String hand) {
        //맨하탄 거리
        int disL = Math.abs(map[number][0]-map[leftpos][0])+Math.abs(map[number][1]-map[leftpos][1]);
        int disR = Math.abs(map[number][0]-map[rightpos][0])+Math.abs(map[number][1]-map[rightpos][1]);
        if(disL<disR){
            leftpos = number;
            return 'L';
        }else if(disL>disR){
            rightpos = number;
            return 'R';

        }else{
            if(hand.equals("right")){
                rightpos = number;
                return 'R';
            } else {
                leftpos = number;
                return 'L';
            }
        }
    }
}
