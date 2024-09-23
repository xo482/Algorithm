import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int t, n;
    static boolean[] sosuArr = new boolean[1_000_001];
    static ArrayDeque<Integer> list = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        sosuArr[0] = sosuArr[1] = true;
        for (int i = 2; i < Math.sqrt(1_000_001); i++) {
            if (!sosuArr[i]) {
                list.add(i);
                for (int j = i*i; j < 1_000_001; j+=i) {
                    sosuArr[j] = true;
                }
            }
        }

        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n==0) break;

            boolean flag = false;
            for (int i : list) {
                if (n / 2 >= i && !sosuArr[n - i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) sb.append("Goldbach's conjecture is wrong.\n");
        }

        System.out.println(sb);
    }
}