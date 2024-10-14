import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Map<String, String> map = new HashMap<>();
    static int N;

    // 항상 하나의 루트가 있는 트리가 만들어진다.
    // 루트 트리 키는 map에 존재하지 않는다.
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        while (N-- > 1) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken(); // 자식
            String B = st.nextToken(); // 부모

            map.put(A, B); // 자식 : 부모
        }

        st = new StringTokenizer(br.readLine());
        String A = st.nextToken(); // 자식
        String B = st.nextToken(); // 부모

        int answer = 0;
        if (check(A, B) || check(B, A)) answer = 1;
        System.out.println(answer);
    }

    // true=형변환가능, false=형변환불가
    static boolean check(String key, String value) {
        if (!map.containsKey(key)) return false;
        if (map.get(key).equals(value)) return true;

        return check(map.get(key), value);
    }
}