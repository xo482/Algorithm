import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int x = 0;
            char[] chars = br.readLine().toCharArray();

            for (char c : chars) {
                if (c == '(') x++;
                else x--;

                if (x < 0) break;
            }

            if (x == 0) sb.append("YES\n");
            else sb.append("NO\n");
        }

        System.out.print(sb);
    }
}