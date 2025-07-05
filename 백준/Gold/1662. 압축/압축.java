import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static char[] line;
    static int len;

    public static void main(String[] args) throws IOException {
        line = br.readLine().toCharArray();
        len = line.length;
        System.out.println(tracking(0)[0]);
    }

    private static int[] tracking(int idx) {
        int ans = 0;
        int i = idx;
        for (; i < len; i++) {
            if (line[i] == ')') break;
            if (i+1 < len && line[i+1] == '(') {
                int[] res = tracking(i + 2);
                ans += (line[i] - '0') * res[0];
                i = res[1];
                continue;
            }

            ans++;
        }

        return new int[]{ans, i};
    }
}

