import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int A, B, N;
    static PriorityQueue<Work> q = new PriorityQueue<>();
    static List<Integer> bl = new ArrayList<>(), rl = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int bT = 0;
        int rT = 0;
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char color =  st.nextToken().charAt(0);
            int cnt = Integer.parseInt(st.nextToken());

            if (color == 'B') {
                if (time > bT) bT = time;
                while (cnt-- > 0) {
                    q.add(new Work(bT, color));
                    bT += A;
                }
            }
            if (color == 'R') {
                if (time > rT) rT = time;
                while (cnt-- > 0) {
                    q.add(new Work(rT, color));
                    rT += B;
                }
            }
        }

        int num = 1;
        while (!q.isEmpty()) {
            Work now = q.poll();
            if (now.color == 'B') bl.add(num);
            else rl.add(num);

            num++;
        }

        sb.append(bl.size()).append("\n");
        for (int i : bl) sb.append(i).append(" ");
        sb.append("\n").append(rl.size()).append("\n");
        for (int i : rl) sb.append(i).append(" ");

        System.out.println(sb);
    }


    static class Work implements Comparable<Work>{
        int startTime;
        char color;

        public Work(int startTime, char color) {
            this.startTime = startTime;
            this.color = color;
        }

        @Override
        public int compareTo(Work o) {
            if (this.startTime == o.startTime) {
                return this.color - o.color;
            }
            return this.startTime - o.startTime;
        }
    }
}
