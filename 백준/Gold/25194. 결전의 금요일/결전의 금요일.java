import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            Set<Integer> temp = new HashSet<>();
            for (int n : set) {
                int value = (n + now) % 7;
                temp.add(value);
            }
            
            set.addAll(temp);
            set.add(now % 7);
        }

        if (set.contains(4)) System.out.println("YES");
        else System.out.println("NO");
    }
}