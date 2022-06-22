package programmers.Lv2;

import java.util.Arrays;

public class visitedLength {
    public int solution(String dirs) {
        int[][] map = new int[101][101]; //from to
        int[] pos = {5,5};
        for (int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            int[] temp = dirChange(ch, pos);
            if(temp[0]<0||temp[1]<0||temp[0]>=10||temp[1]>=10)continue;
            map[pos[0]*10+pos[1]][temp[0]*10+temp[1]]=1;
            map[temp[0]*10+temp[1]][pos[0]*10+pos[1]]=1;
            pos = temp;
        }
        return (int) (Arrays.stream(map).flatMapToInt(Arrays::stream).filter(it->it!=0).count())/2;
    }

    private int[] dirChange(char ch, int[] pos) {
        int nx =pos[0];
        int ny =pos[1];
        if(ch=='U')nx-=1;
        else if (ch=='D') nx += 1;
        else if(ch=='R')ny +=1;
        else if(ch=='L')ny -= 1;

        return new int[]{nx,ny};
    }
}
