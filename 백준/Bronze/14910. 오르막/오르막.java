import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static List<Integer> list = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static boolean flag = false;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            list.add(num);
            pq.add(num);
        }

        for (int a : list) {
            int b = pq.poll();
            if (a != b) {
                flag = true;
                break;
            }
        }
        if (flag) System.out.println("Bad");
        else System.out.println("Good");
    }
}