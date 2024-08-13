import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N,M;
    static List<Integer>[] list;
    static int[] arr;
    static ArrayDeque<Integer> Q = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        arr = new int[N];
        list = new List[N];
        for (int i = 0; i < N; i++) list[i] = new ArrayList<>();

        while (M-- > 0) {
            s = br.readLine().split(" ");
            int start = Integer.parseInt(s[0])-1;
            int end = Integer.parseInt(s[1])-1;
            list[start].add(end);
            arr[end] += 1;
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == 0) {
                Q.addLast(i);
                arr[i] = -1;
            }
        }

        while (!Q.isEmpty()) {
            int now = Q.removeFirst();
            sb.append(now+1).append(" ");

            for (int i : list[now]) {
                if (arr[i] == 1) {
                    Q.addLast(i);
                    arr[i] = -1;
                } else {
                    arr[i] -= 1;
                }
            }
        }

        System.out.println(sb);
    }
}