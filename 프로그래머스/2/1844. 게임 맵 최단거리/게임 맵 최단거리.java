import java.util.*;

class Solution {

    static int n;
    static int m;
    static int[][] map;
    static int[][] visited;
    static boolean flag = false;
    static ArrayDeque<int[]> stack = new ArrayDeque<>();
    static int[] dr;
    static int[] dc;

    public int solution(int[][] maps) {
        map = maps;
        n = maps.length;
        m = maps[0].length;
        visited = new int[n][m];
        dr = new int[]{1, -1, 0 , 0};
        dc = new int[]{0, 0, -1, 1};

        visited[0][0] = 1;
        stack.addLast(new int[]{0, 0});

        while (!stack.isEmpty()) {

            int[] now = stack.removeFirst();
            if (now[0] == n - 1 && now[1] == m - 1) {
                flag = true;
            }

            for (int k = 0; k < 4; k++) {
                int r = now[0] + dr[k];
                int c = now[1] + dc[k];
                if (check(r, c)) {
                    visited[r][c] = visited[now[0]][now[1]] + 1;
                    stack.addLast(new int[]{r,c});
                }
            }
        }

        if (!flag) return -1;
        return visited[n-1][m-1];
    }

    public boolean check(int i, int j) {
        if (i >= 0 && j >= 0 && i < n && j < m && map[i][j] == 1 && visited[i][j]==0) return true;
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    }

}
