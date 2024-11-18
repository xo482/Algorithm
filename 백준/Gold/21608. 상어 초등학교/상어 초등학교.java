import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, answer = 0;
    static int[][] arr; // 실제 자리 2차원 배열
    static List<Integer>[] list; // 좋아하는 친구를 담는 2차원리스트
    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        list = new List[N*N+1];
        for (int i = 1; i < N*N+1; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < N*N; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) list[now].add(Integer.parseInt(st.nextToken()));

            solution(now);
        }

        // 모든 학생들이 자리에 앉은 후

        for (int r = 1; r < N + 1; r++) {
            for (int c = 1; c < N + 1; c++) {

                int cost = 0;
                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr <= 0 || nc <= 0 || nr > N || nc > N) continue;

                    if (list[arr[r][c]].contains(arr[nr][nc])) cost++;
                }

                if (cost == 1) answer += 1;
                if (cost == 2) answer += 10;
                if (cost == 3) answer += 100;
                if (cost == 4) answer += 1000;
            }
        }

        System.out.println(answer);
    }

    private static void solution(int now) {
        PriorityQueue<Info> Q = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                // 1순위 친구가 많아야함 주변에
                // 2순위 친구가 같을 경우 빈칸이 많아야함
                // 3순위 빈칸이 같을 경우 행이 더 작아야함
                // 4순위 행이 같을 경우 열이 더 작아야함


                if (o1.cost == o2.cost) {
                    if (o1.empty == o2.empty) {
                        if (o1.r == o2.r) {
                            return o1.c - o2.c;
                        }
                        return o1.r - o2.r;
                    }
                    return o2.empty - o1.empty;
                }
                return o2.cost - o1.cost;
            }
        });
        for (int r = 1; r < N + 1; r++) {
            for (int c = 1; c < N + 1; c++) {
                if (arr[r][c] != 0) continue;

                int empty = 0;
                int cost = 0;

                for (int i = 0; i < 4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr <= 0 || nc <= 0 || nr > N || nc > N) continue; // 범위를 벗어나면

                    if (arr[nr][nc] == 0) { empty++; continue;}
                    if (list[now].contains(arr[nr][nc])) cost++;
                }

                Q.add(new Info(r, c, cost, empty));
            }
        }

        Info best = Q.poll();
        arr[best.r][best.c] = now;
    }

    static class Info {
        int r,c; // 위치
        int cost; // 해당 위치 주변에 좋아하는 사람 수
        int empty;

        public Info(int r, int c, int cost, int empty) {
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.empty = empty;
        }
    }
}