package BOJ.Gold;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


public class BOJ1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1-o2);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int read = Integer.parseInt(br.readLine());

            if(minHeap.size()==maxHeap.size()) maxHeap.add(read);
            else minHeap.add(read);

            if(!minHeap.isEmpty()&&!maxHeap.isEmpty())
                if(minHeap.peek()<maxHeap.peek()){
                    int temp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(temp);
                }

            sb.append(maxHeap.peek()).append("\n");

        }
        System.out.println(sb);
    }
}
