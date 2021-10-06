package BOJ.Gold;

class xy implements Comparable<xy> {
    int x;
    int y;
    int value;

    xy(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(xy o) {

        return this.value > o.value ? 1 : -1;
    }
}
