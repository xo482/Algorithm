import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int k;
    static ArrayDeque<Integer> stack = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            int val = Integer.parseInt(br.readLine());
            if (val == 0) stack.removeLast();
            else stack.addLast(val);
        }

        int sum = 0;
        for (int i : stack) {
            sum += i;
        }

        System.out.print(sum);
    }
}