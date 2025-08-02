import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T;
    static char[] line;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            line = br.readLine().toCharArray();
            sb.append(tracking(0, line.length - 1, false)).append("\n");
        }
        System.out.print(sb);
    }

    private static int tracking(int p1, int p2, boolean flag) {

        if (p1 >= p2) {
            if (flag) return 1;
            return 0;
        }

        int ans = 2;
        if (line[p1] == line[p2]) return tracking(p1+1, p2-1, flag);
        if (!flag && line[p1+1] == line[p2]) ans = Math.min(ans, tracking(p1 + 1, p2, true));
        if (!flag && line[p1] == line[p2-1]) ans = Math.min(ans, tracking(p1, p2 - 1, true));

        return ans;
    }
}