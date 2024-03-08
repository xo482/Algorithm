import java.io.*;
import java.util.*;

public class Main {
    static int[][] list = null;
    static int N=0;
    static int M=0;
    static int answer=1;

    public static void logic(int i, int j) {
        int value = list[i][j];
        int down = 0, area = 0;

        for (int k = j+1; k < M; k++) {
            down = k - j;
            if (check(i + down) && value == list[i][k]) {
                if (list[i + down][j] == value && list[i + down][k] == value) {
                    area = (down+1)*(down+1);
                    if (area > answer) answer = area;
                }
            }
        }
    }

    private static boolean check(int i) {
        return i < N;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N][M];

        // init
        for(int i=0; i<N; i++) {
            String[] line = br.readLine().split("");
            for(int j=0; j<M; j++) {
                list[i][j] = Integer.parseInt(line[j]);
            }
        }

        //logic
        for(int i=0; i<N-1; i++) {
            for(int j=0; j<M-1; j++) {
                logic(i,j);
            }
        }

        System.out.println(answer);
    }
}