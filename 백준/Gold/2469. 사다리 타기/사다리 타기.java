import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int k, n;
    static char[] start;
    static char[] result;
    static char[] condition;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        k = Integer.parseInt(br.readLine());
        n = Integer.parseInt(br.readLine());
        start = new char[k];
        condition = new char[k - 1];
        Arrays.fill(condition, '*');

        for (int i = 0; i < k; i++) start[i] = (char)('A' + i);
        result = br.readLine().toCharArray();
        board = new char[n][k - 1];
        int p = 0;
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
            if (board[i][0] == '?') p = i;
        }

        for (int i = 0; i < p; i++) change(start, board[i]);
        for (int i = n-1; i > p; i--) change(result, board[i]);

        tracking(0, 0);

        if (sb.toString().isEmpty()) System.out.println("x".repeat(k - 1));
        else System.out.println(sb);
    }

    static void change(char[] arr, char[] condition) {
        for (int i = 1; i < arr.length; i++) {
            if (condition[i-1] == '-') {
                char temp = arr[i - 1];
                arr[i - 1] = arr[i];
                arr[i] = temp;
            }
        }
    }
    static void tracking(int idx, int depth) {
        if (depth == k - 1) {

            boolean fl = false;
            for (int i = 1; i < k - 1; i++)
                if (condition[i-1] == '-' && condition[i] == '-')
                    fl = true;
            if (fl) return;


            change(start, condition);
            boolean flag = false;
            for (int i = 0; i < k; i++) {
                if (start[i] != result[i]) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                for (int i = 0; i < k-1; i++)
                    sb.append(condition[i]);


            change(start, condition);
            return;
        }
        for (int i = 0; i < 2; i++) {
            if (i==0) condition[idx] = '-';
            else condition[idx] = '*';
            tracking(idx + 1, depth + 1);
        }
    }
}