import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static Map<Integer, Integer> map = new HashMap<>();
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            map.put(Integer.parseInt(st.nextToken()), 0);


        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            if (map.containsKey(Integer.parseInt(st.nextToken())))
                sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.print(sb);
    }
}
