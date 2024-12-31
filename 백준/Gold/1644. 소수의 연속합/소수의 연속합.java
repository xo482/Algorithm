import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, cnt = 0;
    static boolean[] visited;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        if (N==1) {
            System.out.println(0);
            return;
        }
        visited = new boolean[N+1];

        visited[0] = true;
        visited[1] = true;
        for (int i = 2; i < N+1; i++) {
            if (visited[i]) continue;
            for (int j = 2*i; j < N+1; j += i) visited[j] = true;

            list.add(i);
        }

        int p1 = 0;
        int p2 = 0;
        int sum = 2;
        while (p1 <= p2) {
            if (sum < N) {
                if (++p2 >= list.size()) break;
                sum += list.get(p2);
                continue;
            }

            if (sum > N) {
                sum -= list.get(p1++);
                continue;
            }

            cnt++;
            sum -= list.get(p1++);
        }

        System.out.println(cnt);
    }
}