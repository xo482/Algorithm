import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PriorityQueue<Integer> Q = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        br.readLine();

        String[] split = br.readLine().split(" ");
        for (String s : split) Q.add(Integer.parseInt(s));

        split = br.readLine().split(" ");
        for (String s : split) Q.add(Integer.parseInt(s));

        while (!Q.isEmpty()) sb.append(Q.poll()).append(" ");
        System.out.println(sb);
    }
}