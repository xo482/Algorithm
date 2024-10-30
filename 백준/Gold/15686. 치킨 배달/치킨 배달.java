import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, total = Integer.MAX_VALUE;
    static int[][] city;
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
                if (city[i][j] == 2) list.add(new int[]{i, j});
            }
        }

        tracking(0,0);
        System.out.println(total);
    }

    private static void tracking(int start, int depth) {
        // 치킨집의 개수가 원하는 개수가 되었을 때
        if (list.size() - depth == M){

            int sum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (city[i][j] == 1){
                        int min = 1000000;
                        for (int[] ints : list) {
                            int r = ints[0];
                            int c = ints[1];
                            if (city[r][c] == 2)min = Math.min(min, Math.abs(r-i)+Math.abs(c-j));
                        }

                        sum += min;
                    }
                }
            }

            total = Math.min(total, sum);
        }

        for (int i = start; i < list.size(); i++) {
            int[] ints = list.get(i);
            int r = ints[0];
            int c = ints[1];

            city[r][c] = 0;
            tracking(i+1, depth+1);
            city[r][c] = 2;
        }
    }
}