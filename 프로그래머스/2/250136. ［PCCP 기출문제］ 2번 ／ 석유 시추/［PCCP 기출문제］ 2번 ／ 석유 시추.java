import java.util.*;

class Solution {
    static int[] dr = new int[]{1,-1,0,0};
    static int[] dc = new int[]{0,0,-1,1};
    static int[] line;
    static boolean[][] visited;

    public int solution(int[][] land) {
        line = new int[land[0].length];
        visited = new boolean[land.length][land[0].length];

        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[0].length; j++) {
                if(land[i][j] == 0) continue;
                if(visited[i][j]) continue;

                int cnt = 0;
                Set<Integer> set = new HashSet();
                ArrayDeque<int[]> Q = new ArrayDeque<>();
                Q.addLast(new int[]{i,j});
                visited[i][j] = true;

                while(!Q.isEmpty()) {
                    int[] point = Q.removeFirst();
                    int r = point[0];
                    int c = point[1];
                
                    set.add(c);
                    cnt++;

                    for(int k = 0; k < 4; k++) {
                        int nr = r + dr[k];
                        int nc = c + dc[k];

                        if(nr >= land.length || nr < 0 || nc >= land[0].length || nc < 0) continue;
                        if(visited[nr][nc]) continue;
                        if(land[nr][nc] == 0) continue;

                        visited[nr][nc] = true;
                        Q.add(new int[]{nr,nc});
                    }
                }

                for(int k : set) {
                    line[k] += cnt;
                }
            }
        }

        int max = -1;
        for(int i : line) {
            max = Math.max(max, i);
        }

        return max;
    }
}