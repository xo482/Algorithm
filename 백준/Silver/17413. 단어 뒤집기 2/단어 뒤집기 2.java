import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static ArrayDeque<Character> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        String line = br.readLine();

        for (int i = 0; i < line.length(); i++) {
            char now = line.charAt(i);

            if (now == ' ') {
                while (!Q.isEmpty()) sb.append(Q.removeLast());
                sb.append(now);
                continue;
            }

            if (now=='<') {
                while (!Q.isEmpty()) sb.append(Q.removeLast());
                for (int j = i; j < line.length(); j++) {
                    sb.append(line.charAt(j));
                    if (line.charAt(j) == '>') {
                        i = j;
                        break;
                    }
                }
                continue;
            }

            Q.addLast(now);
        }

        while (!Q.isEmpty()) sb.append(Q.removeLast());

        System.out.println(sb);
    }
}