import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        char[] chars = br.readLine().toCharArray();
        int p1 = 0;
        int p2 = 1;
        
        int chance = K;
        while (true) {
            if (chance == 0) break;
            if (p2 >= N) break;

            while (p1 >= 0 && chars[p1] < chars[p2]) {
                if (chars[p1] == '!') {
                    p1--;
                    continue;
                }

                chars[p1--] = '!';
                chance--;

                if (chance == 0) break;
            }

            p1 = p2;
            p2++;
        }

        int cnt = 0;
        for (char c : chars) {
            if (c == '!') continue;
            if (cnt == N - K) break;
            sb.append(c);
            cnt++;
        }
        
        System.out.println(sb);
    }
}
