import java.io.*;
import java.util.*;


// 스트링빌더 사용하면 틀립니다.

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, endDepth, end;
    static Map<Integer, Integer[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            map.put(P, new Integer[]{L, R});
        }

        inorder(1);
        findDepth(1, end, 0);

        System.out.println((N-1)*2 - endDepth);
    }

    private static void findDepth(int start, int end, int depth) {
        if (start == end){
            endDepth = depth;
            return;
        }
        
        Integer[] node = map.get(start);
        int L = node[0];
        int R = node[1];

        if (L != -1) findDepth(L, end, depth + 1);
        if (R != -1) findDepth(R, end, depth + 1);
    }

    private static void inorder(int num) {
        Integer[] node = map.get(num);
        int L = node[0];
        int R = node[1];

        if (L != -1) inorder(L);
        end = num;
        if (R != -1) inorder(R);

    }
}