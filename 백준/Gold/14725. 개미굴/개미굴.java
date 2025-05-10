import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st,preSt;
    static int N;
    static PriorityQueue<String> Q = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Q.add(str.substring(2));
        }

        String pre = null;
        while (!Q.isEmpty()) {

            String now = Q.poll();
            st = new StringTokenizer(now);
            int floor = 0;

            if (pre != null) {
                preSt = new StringTokenizer(pre);
                while (true) {
                    String token = st.nextToken();
                    String preToken = preSt.nextToken();
                    if (!token.equals(preToken)) {
                        sb.append("--".repeat(floor++)).append(token).append("\n");
                        break;
                    }

                    floor++;
                }
            }

            while (st.hasMoreTokens())
                sb.append("--".repeat(floor++)).append(st.nextToken()).append("\n");
            pre = now;
        }

        System.out.println(sb);
    }
}