import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int max = 0;
        int min = 256;
        int minTime = 100_000_000;
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(st.nextToken());
                max = Math.max(max, height);
                min = Math.min(min, height);
                map[i][j] = height;
            }
        }



        int len = max - min;
        for (int i = 0; i <= len; i++) {
            int time = 0;
            int standard = max - i;
            long inventory = B;

            // 잘라낸다
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] > standard) {

                        // 차이 구하고
                        int distance = map[j][k] - standard;

                        // 인벤에 넣는다.
                        inventory += distance;

                        // 시간 계산
                        time += 2 * distance;
                    }
                }
            }

            // 채운다
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[j][k] < standard) {

                        // 차이 구하고
                        int distance = standard - map[j][k];

                        // 인벤에 넣는다.
                        inventory -= distance;

                        // 시간 계산
                        time += distance;

                        // 인벤이 음수가 되면 블록이 부족한 것이므로 종료
//                        if ()
                    }
                }
            }

            // 인벤이 음수가 되면 블록이 부족한 것이므로 종료
            if (inventory < 0) continue;

            if (minTime > time) {
                minTime = time;
                maxHeight = standard;
            }
        }

        System.out.print(minTime + " " + maxHeight);
    }
}
