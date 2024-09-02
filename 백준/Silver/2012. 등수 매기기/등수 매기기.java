import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] visited;
    static long sum = 0;
    static PriorityQueue<Integer> Q = new PriorityQueue<>();
    static PriorityQueue<Integer> emptyQ = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > N || visited[num]) Q.add(num);
            else visited[num] = true;
        }
        for (int i = 1; i <= N; i++)
            if (!visited[i])
                emptyQ.add(i);

        while (!Q.isEmpty()) {
            int num = Q.poll();
            int num2 = emptyQ.poll();
            sum += Math.abs(num - num2);
        }


        System.out.println(sum);
    }
}