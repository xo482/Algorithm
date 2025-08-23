import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static PriorityQueue<Mogi> q = new PriorityQueue<>();
    static PriorityQueue<Integer> out = new PriorityQueue<>();
    static int N, count = 0;
    static int[] maxInfo = new int[3];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int inTime = Integer.parseInt(st.nextToken());
            int outTime = Integer.parseInt(st.nextToken());
            q.add(new Mogi(inTime, outTime));
        }

        while (!q.isEmpty()) {
            Mogi mogi = q.poll();

            while (!out.isEmpty() && out.peek() <= mogi.in) {
                out.poll();
                count--;
            }

            out.add(mogi.out);
            count++;

            if (maxInfo[2] == count) {
                if (maxInfo[1] == mogi.in) {
                    maxInfo[1] = out.peek();
                    maxInfo[2] = count;
                }
            }

            if (maxInfo[2] < count) {
                maxInfo[0] = mogi.in;
                maxInfo[1] = out.peek();
                maxInfo[2] = count;
            }
        }

        System.out.println(maxInfo[2] + "\n" + maxInfo[0] + " " + maxInfo[1]);
    }

    static class Mogi implements Comparable<Mogi> {
        int in, out;

        public Mogi(int in, int out) {
            this.in = in;
            this.out = out;
        }

        @Override
        public int compareTo(Mogi o) {
            if (this.in == o.in) return this.out - o.out;
            return this.in - o.in;
        }
    }
}


//arr1 = br.readLine().toCharArray();
//arr2 = br.readLine().toCharArray();
//int len1 = arr1.length;
//int len2 = arr2.length;
//
//        for (int i = 0; i < len1; i++) {
//
//        for (int j = 0; j < len2; j++) {
//        if ()
//        }
//        }