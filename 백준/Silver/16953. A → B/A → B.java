import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int A, B;
    static ArrayDeque<int[]> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        Q.add(new int[]{A, 1});
        while (!Q.isEmpty()) {
            int[] now = Q.removeFirst();
            if (now[0] == B) {
                System.out.println(now[1]);
                return;
            }


            long nxt = 2L * now[0];
            if (nxt <= B) Q.add(new int[]{(int)nxt, now[1] + 1});
            nxt = 10L * now[0] + 1;
            if (nxt <= B) Q.add(new int[]{(int)nxt, now[1] + 1});
        }

        System.out.println(-1);
    }
}