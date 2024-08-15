import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int T;
    static boolean[] list = new boolean[1000001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        Arrays.fill(list, true);
        for (int i = 2; i < Math.sqrt(1000001); i++) if (list[i]) for (int j = i*i; j <1000001; j += i) list[j] = false;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int i = 2; i <= n/2; i++) if (list[i] && list[n - i]) cnt++;
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}