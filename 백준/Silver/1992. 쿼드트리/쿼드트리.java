import java.io.*;
import java.util.*;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int[][] arr;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }

        System.out.println(method(N, 0, 0));
    }

    private static String method(int depth, int r, int c) {
        StringBuilder sb = new StringBuilder();
        if (depth == 1) {
            if (arr[r][c] == 1) return "1";
            else return "0";
        }

        int next = depth/2;
        String s1 = method(next, r, c);
        String s2 = method(next, r, c + next);
        String s3 = method(next, r + next, c);
        String s4 = method(next, r + next, c + next);

        if (s1.equals(s2) && s1.equals(s3) && s1.equals(s4) && (s1.equals("0") || s1.equals("1"))) {
            sb.append(s1);
        } else {
            sb.append("(").append(s1).append(s2).append(s3).append(s4).append(")");
        }

        return sb.toString();
    }
}
