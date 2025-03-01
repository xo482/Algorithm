import java.io.*;
import java.util.*;

class Solution {

    static int N, M, target, request;
    static int[][] board;
    static boolean[][] visited;
    static ArrayDeque<int[]> Q;
    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, -1, 1};

    public static void main(String[] args) {
        String[] storage = new String[]{"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] requests = new String[]{"A", "BB", "A"};
        System.out.println(solution(storage, requests));
    }

    public static int solution(String[] storage, String[] requests) {
        N = storage.length;
        M = storage[0].length();
        board = new int[N + 2][M + 2];
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= M; j++)
                board[i][j] = storage[i-1].charAt(j-1);


        for (String s : requests) {
            target = s.charAt(0);
            request = s.length();

            if (request == 1) req1();
            if (request == 2) req2();
        }

        return getAnswer();
    }


    private static void req1() {
        Q = new ArrayDeque<>();
        visited = new boolean[N + 2][M + 2];

        Q.add(new int[]{0, 0});
        visited[0][0] = true;
        while (!Q.isEmpty()) {
            int[] now = Q.removeFirst();
            int r = now[0];
            int c = now[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= N+2 || nc >= M+2 || nr < 0 || nc < 0) continue;
                if (visited[nr][nc]) continue;
                if (board[nr][nc] != 0) {
                    if (board[nr][nc] == target){
                        board[nr][nc] = 0;
                        visited[nr][nc] = true; // 재방문 방어
                    }
                    continue;
                }

                visited[nr][nc] = true;
                Q.add(new int[]{nr, nc});
            }
        }

    }

    private static void req2() {
        for (int i = 1; i <= N+1; i++)
            for (int j = 1; j <= M+1; j++)
                if (board[i][j] == target)
                    board[i][j] = 0;
    }

    private static int getAnswer() {
        int answer = 0;
        for (int i = 1; i <= N+1; i++)
            for (int j = 1; j <= M+1; j++)
                if (board[i][j] != 0)
                    answer++;
        return answer;
    }
}