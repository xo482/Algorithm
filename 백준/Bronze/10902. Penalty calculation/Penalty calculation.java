import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static PriorityQueue<Answer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            pq.add(new Answer(i, t, s));
        }
        Answer poll = pq.poll();
        if (poll.score == 0) System.out.println(0);
        else System.out.println(poll.time + (poll.num-1) * 20);
    }
    static class Answer implements Comparable<Answer> {
        int num, time, score;

        public Answer(int num, int time, int score) {
            this.num = num;
            this.time = time;
            this.score = score;
        }


        @Override
        public int compareTo(Answer o) {
            if (o.score == score) {
                return time - o.time;
            }
            return o.score - this.score;
        }
    }
}