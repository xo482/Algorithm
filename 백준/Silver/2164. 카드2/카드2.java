import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static boolean flag = true;
    static ArrayDeque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) deque.addLast(i);

        while (deque.size() > 1) {
            if (flag) {
                deque.removeFirst();
                flag = false;
            } else {
                deque.addLast(deque.removeFirst());
                flag = true;
            }
        }
        System.out.print(deque.removeFirst());
    }
}