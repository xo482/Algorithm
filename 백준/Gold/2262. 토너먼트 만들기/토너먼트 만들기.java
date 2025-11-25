import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, ans = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        list.add(0);
        for (int i = 0; i < N; i++) list.add(Integer.parseInt(st.nextToken()));
        list.add(0);

        while (N > 1) {

            int idx = -1;
            int max = -1;
            for (int i = 1; i <= N; i++) {
                int now = list.get(i);
                if (now > max) {
                    max = list.get(i);
                    idx = i;
                }
            }

            ans += list.get(idx) - Math.max(list.get(idx - 1), list.get(idx + 1));
            list.remove(idx);
            N--;
        }
        System.out.println(ans);
    }
}