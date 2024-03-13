import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken()); // 리스트 최소 길이

        for (int i = L; i <= 100; i++) {
            int start = N/i - (i-1)/2;
            if (start < 0) break;

            if (N == i*(i + 2 * start - 1) / 2) {
                for (int j = 0; j < i; j++) {
                    sb.append(start + j).append(" ");
                }
                System.out.println(sb);
                return;
            }
        }
        System.out.println("-1");
    }
}