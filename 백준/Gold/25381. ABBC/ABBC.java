import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans = 0;
    static PriorityQueue<Integer> A = new PriorityQueue<>();
    static PriorityQueue<Integer> B = new PriorityQueue<>();
    static PriorityQueue<Integer> C = new PriorityQueue<>();

    public static void main(String[] args) throws Exception {
        String line = br.readLine();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == 'A') A.add(i);
            else if (c == 'B') B.add(i);
            else if (c == 'C') C.add(i);
        }

        while (!B.isEmpty() && !C.isEmpty()) {
            if (B.peek() > C.peek()) {
                C.poll();
                continue;
            }

            B.poll();
            C.poll();
            ans++;
        }

        while (!A.isEmpty() && !B.isEmpty()) {
            if (A.peek() > B.peek()) {
                B.poll();
                continue;
            }

            A.poll();
            B.poll();
            ans++;
        }

        System.out.println(ans);
    }
}

// AABCB
// B먼저 처리한다 이를 통해 A가 하나 손해 보는 경우가 생기더라도 최대 횟수는 같다.