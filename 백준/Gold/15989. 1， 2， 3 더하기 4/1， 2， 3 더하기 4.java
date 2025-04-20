import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int T;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {

            int num = Integer.parseInt(br.readLine());
            int i = -1;
            int cnt = 0;

            while (++i * 3 <= num) {
                int v = num - (i * 3);
                cnt += v / 2 + 1;
            }

            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}