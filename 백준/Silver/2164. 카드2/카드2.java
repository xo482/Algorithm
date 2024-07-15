import java.io.*;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        boolean flag = false;
        int answer = 0;

        for (int i = 1; i < N + 1; i++) Q.addLast(i);

        while (!Q.isEmpty()) {
            answer = Q.removeFirst();

            if (flag) Q.addLast(answer);
            flag = !flag;
        }

        System.out.print(answer);
    }
}