import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N, K = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        hanoi(N, 1, 3, 2);
        System.out.println(K);
        System.out.println(sb);
    }

    public static void hanoi(int n, int from, int to, int other) {
        if (n == 0) return;

        K++;
        hanoi(n - 1, from, other, to);
        sb.append(from + " " + to + "\n");
        hanoi(n - 1, other, to, from);
    }
}