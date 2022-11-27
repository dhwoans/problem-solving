package BOJ.Gold;

class Node implements Comparable<Node> {
    int to;
    int value;

    Node(int to, int value) {
        this.to = to;
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;
    }
}
