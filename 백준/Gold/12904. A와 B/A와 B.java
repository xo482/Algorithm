import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        String s = br.readLine();
        int len = s.length();
        StringBuilder sb = new StringBuilder(br.readLine());

        int size;
        while ((size = sb.length()) >= len) {
            if (s.equals(sb.toString())) ans = 1;

            if (sb.charAt(size-1) == 'A') {
                sb.replace(size - 1, size, "");
                continue;
            }

            if (sb.charAt(size-1) == 'B') {
                sb.replace(size - 1, size, "");
                sb.reverse();
            }
        }

        System.out.println(ans);
    }
}