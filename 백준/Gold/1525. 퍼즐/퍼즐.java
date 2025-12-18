import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int SIZE = 3;
    static int[] move = new int[]{1, -1, -3, 3};
    static int min_move = -1;
    static char[] board = new char[SIZE * SIZE];
    static String answer = "123456780";
    static ArrayDeque<Snapshot> Q = new ArrayDeque<>();
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < SIZE; i++) {
            String[] split = br.readLine().split(" ");
            for (int j = 0; j < SIZE; j++) board[3 * i + j] = split[j].charAt(0);
        }

        String snapshot = new String(board);
        visited.add(snapshot);
        Q.add(new Snapshot(snapshot, 0));


        while (!Q.isEmpty()) {
            Snapshot now = Q.removeFirst();
            if (answer.equals(now.snapshot)) {
                min_move = now.cnt;
                break;
            }

            int zero_idx = now.snapshot.lastIndexOf('0');
            for (int i = 0; i < 4; i++) {
                int nxt_idx = zero_idx + move[i];
                if (nxt_idx < 0 || nxt_idx >= SIZE * SIZE) continue;
                if ((i == 0 || i == 1) && (nxt_idx / 3 != zero_idx / 3)) continue;

                char[] chars = now.snapshot.toCharArray();
                chars[zero_idx] = chars[nxt_idx];
                chars[nxt_idx] = '0';
                String nxt_snapshot = new String(chars);
                if (visited.contains(nxt_snapshot)) continue;

                Q.add(new Snapshot(nxt_snapshot, now.cnt + 1));
                visited.add(nxt_snapshot);
            }
        }

        System.out.println(min_move);
    }


    static class Snapshot {
        String snapshot;
        int cnt;

        public Snapshot(String snapshot, int cnt) {
            this.snapshot = snapshot;
            this.cnt = cnt;
        }
    }

}