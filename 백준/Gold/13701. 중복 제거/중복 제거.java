import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BitSet bitSet = new BitSet(33554432);

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int x = Integer.parseInt(st.nextToken());

            if (!bitSet.get(x)) {
                bitSet.set(x);
                sb.append(x).append(' ');
            }
        }
        System.out.print(sb);
    }
}