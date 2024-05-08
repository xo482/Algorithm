import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringBuilder str1 = new StringBuilder();
    static StringBuilder str2 = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int start = 0;
        int val = 0;
        int num = 1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            val = Integer.parseInt(br.readLine());
            str1.append(val);

            if (start < val) {
                for (int j = 0; j < val - start; j++) {
                    stack.addLast(num++);
                    sb.append("+\n");
                }
                str2.append(stack.removeLast());
                sb.append("-\n");
                start = val;
            } else {
                str2.append(stack.removeLast());
                sb.append("-\n");
            }
        }

        if (str1.toString().equals(str2.toString())) System.out.println(sb);
        else System.out.println("NO");
    }
}