import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Character> list = new ArrayList<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));
    static int len;
    static long cnt = 0;
    static char[] chars;

    public static void main(String[] args) throws Exception {
        chars = br.readLine().toCharArray();
        len = chars.length;

        tracking(0, 0, 0, false, 1);
        System.out.println(cnt);
    }

    private static void tracking(int idx, int mc, int zc, boolean flag, long sum) {
        if (idx == len) {
            if (!flag) return;

            cnt += sum;
            return;
        }

        char c = chars[idx];
        if (c == '_') {
            if (mc < 2) {
                tracking(idx + 1, mc + 1, 0, flag, sum * 5);
            }
            if (zc < 2) {
                tracking(idx + 1, 0, zc + 1, true, sum);
                tracking(idx + 1, 0, zc + 1, flag, sum * 20);
            }
            return;
        }

        if (list.contains(c) && mc < 2) {
            tracking(idx + 1, mc + 1, 0, flag, sum);
        }

        if (!list.contains(c) && zc < 2) {
            if (c == 'L') tracking(idx + 1, 0, zc + 1, true, sum);
            else tracking(idx + 1, 0, zc + 1, flag, sum);
        }
    }
}