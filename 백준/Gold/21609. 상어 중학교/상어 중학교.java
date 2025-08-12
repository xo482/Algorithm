import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] board;
    static boolean[][] visited;
    static int N, M, answer = 0;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) board[i][j] = Integer.parseInt(st.nextToken());
        }

        while (true) {

            visited = new boolean[N][N];
            PriorityQueue<GroupInfo> groupInfo_Q = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) continue;
                    if (board[i][j] == 0 || board[i][j] == -1 || board[i][j] == -2) continue;

                    GroupInfo groupInfo = new GroupInfo(i, j);
                    groupInfo.addPoint(i, j);
                    groupInfo.increaseTotalSize();

                    ArrayDeque<int[]> recovery_Q = new ArrayDeque<>();
                    ArrayDeque<int[]> Q = new ArrayDeque<>();

                    Q.add(new int[]{i, j, board[i][j]});
                    visited[i][j] = true;
                    while (!Q.isEmpty()) {
                        int[] now = Q.removeFirst();
                        int r = now[0];
                        int c = now[1];
                        int num = now[2];

                        for (int k = 0; k < 4; k++) {
                            int nr = r + dr[k];
                            int nc = c + dc[k];

                            if (nr >= N || nr < 0 || nc >= N || nc < 0) continue;
                            if (visited[nr][nc]) continue;
                            if (board[nr][nc] != 0 && board[nr][nc] != num) continue;

                            Q.add(new int[]{nr, nc, num});
                            visited[nr][nc] = true;

                            groupInfo.addPoint(nr, nc);
                            groupInfo.increaseTotalSize();

                            if (board[nr][nc] == 0) {
                                recovery_Q.add(new int[]{nr, nc});
                                groupInfo.increaseRainSize();
                            }
                        }
                    }

                    if (groupInfo.points.size() > 1)
                        groupInfo_Q.add(groupInfo);
                    for (int[] point : recovery_Q) {
                        visited[point[0]][point[1]] = false;
                    }
                }
            }

            if (groupInfo_Q.isEmpty()) break;

            GroupInfo groupInfo = groupInfo_Q.poll();
            for (int[] point : groupInfo.points) board[point[0]][point[1]] = -2;
            answer += (int) Math.pow((double) groupInfo.totalSize, 2);
            setting();
        }

        System.out.println(answer);
    }

    // 돌려서 새로운 보드 보내줌
    private static void setting() {
        gravity();

        int[][] newBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                newBoard[N-1-j][i] = board[i][j];
            }
        }
        board = newBoard;

        gravity();
    }

    private static void gravity() {
        for (int i = N-2; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != -2 && board[i][j] != -1) {
                    int r = i+1;

                    while (true) {
                        if (r == N) break;
                        if (board[r][j] != -2) break;
                        r += 1;
                    }

                    if (board[r-1][j] == -2) {
                        board[r-1][j] = board[i][j];
                        board[i][j] = -2;
                    }
                }
            }
        }
    }

    private static class GroupInfo implements Comparable<GroupInfo> {
        int standardR, standardC;
        int totalSize = 0, rainSize = 0;
        ArrayDeque<int[]> points = new ArrayDeque<>();

        public GroupInfo(int standardR, int standardC) {
            this.standardR = standardR;
            this.standardC = standardC;
        }

        public void increaseTotalSize() {
            totalSize++;
        }

        public void increaseRainSize() {
            rainSize++;
        }

        public void addPoint(int r, int c) {
            points.add(new int[]{r, c});
        }

        @Override
        public int compareTo(GroupInfo o) {

            if (o.totalSize == this.totalSize) {
                if (o.rainSize == this.rainSize) {
                    if (o.standardR == this.standardR) {
                        return o.standardC - this.standardC;
                    }
                    return o.standardR - this.standardR;
                }
                return o.rainSize - this.rainSize;
            }
            return o.totalSize - this.totalSize;
        }
    }
}