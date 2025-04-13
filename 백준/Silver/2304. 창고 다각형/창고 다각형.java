import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Bar> list = new ArrayList<>();
    static int N, pos, hi;
    static int maxHigh=0, answer=0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pos = Integer.parseInt(st.nextToken());
            hi = Integer.parseInt(st.nextToken());
            list.add(new Bar(pos, hi));

            maxHigh = Math.max(maxHigh, hi);
        }

        Collections.sort(list);
        answer = maxHigh * (list.get(N - 1).pos - list.get(0).pos + 1);

        for (int i = 0; i < N - 1; i++) {
            Bar now = list.get(i);

            int idx = 0, h = 0;
            boolean flag = false;

            for (int j = i + 1; j < N; j++) {
                Bar nxt = list.get(j);
                if (now.hi < nxt.hi) {
                    answer -= (maxHigh - now.hi) * (nxt.pos - now.pos);
                    flag = true;
                    i = j - 1;
                    break;
                }

                if (h <= nxt.hi) {
                    h = nxt.hi;
                    idx = j;
                }
            }
            if (flag) continue;

            answer -= (maxHigh - h) * (list.get(idx).pos - now.pos);
            i = idx-1;
        }

        System.out.println(answer);
    }

    static class Bar implements Comparable<Bar>{
        int pos, hi;

        public Bar(int pos, int hi) {
            this.pos = pos;
            this.hi = hi;
        }

        @Override
        public int compareTo(Bar o) {
            return this.pos - o.pos;
        }
    }
}
