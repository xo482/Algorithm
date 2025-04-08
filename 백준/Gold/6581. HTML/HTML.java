import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        while (true) {
            String s = br.readLine();
            if (s == null) break;
            if (s.isEmpty()) continue;

            st = new StringTokenizer(s);
            while (st.hasMoreTokens()) {
                String now = st.nextToken();
                int len = now.length();

                if (now.equals("<br>")) {
                    System.out.println(sb.toString().trim());
                    sb = new StringBuilder();
                    continue;
                }
                if (now.equals("<hr>")) {
                    if (!sb.toString().equals(""))System.out.println(sb.toString().trim());
                    System.out.println("--------------------------------------------------------------------------------");
                    sb = new StringBuilder();
                    continue;
                }

                if (sb.length() + len > 80) {
                    System.out.println(sb.toString().trim());
                    sb = new StringBuilder();
                    sb.append(now).append(" ");
                }
                else {
                    sb.append(now).append(" ");
                }
            }

        }

        if (!sb.toString().equals("")) System.out.print(sb.toString().trim());
    }
}