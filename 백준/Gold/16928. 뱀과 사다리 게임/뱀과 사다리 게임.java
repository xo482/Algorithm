import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[] board = new int[101];
    static ArrayDeque<Integer> Q = new ArrayDeque<>();
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Q.add(1);
        while (!Q.isEmpty()) {
            int now = Q.poll();

            if (now==100) break;

            if (map.containsKey(now)) {
                board[map.get(now)] = board[now];
                now = map.get(now);
            }

            for (int i = 1; i < 7; i++) {
                int nxt = now + i;
                if (nxt < 101 && board[nxt] == 0) {
                    board[nxt] = board[now] + 1;
                    Q.add(nxt);
                }
            }
        }

        System.out.println(board[100]);
    }
}