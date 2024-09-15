import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            char[] array = br.readLine().toCharArray();
            int cnt = 0;

            for (int i = 0; i < array.length; i++) {
                if (array[i] == '(') cnt++;
                if (array[i] == ')') cnt--;
                if (cnt < 0) break;
            }
            if (cnt == 0) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}