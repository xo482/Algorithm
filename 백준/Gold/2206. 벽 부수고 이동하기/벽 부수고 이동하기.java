import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static int[][] board;
    static int answer = -1;
    static boolean[][][] visited;
    static int[] dr = new int[]{-1,1,0,0};
    static int[] dc = new int[]{0,0,1,-1};
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M][2];
        
        for(int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) 
                board[i][j] = chars[j] - '0';
        }
        
        ArrayDeque<Node> Q = new ArrayDeque<>();
        Q.addLast(new Node(0,0,1,1));
        while(!Q.isEmpty()) {
            Node now = Q.removeFirst();
            if(now.r == N-1 && now.c == M-1) {
                answer = now.cost;
                break;
            }
            
            for(int k = 0; k < 4; k++) {
                int nr = now.r + dr[k];
                int nc = now.c + dc[k];
                
                if(nr >= N || nr < 0 || nc >= M || nc < 0) continue;
                
                if(now.chance == 1 && board[nr][nc] == 1 && !visited[nr][nc][1]) {
                    visited[nr][nc][1] = true;
                    Q.add(new Node(nr, nc, now.cost+1, 0));
                }
                
                if(now.chance == 0 && visited[nr][nc][0]) continue;
                if(now.chance == 1 && visited[nr][nc][1]) continue;
                if(board[nr][nc] == 1) continue;
                
                if(now.chance == 0) visited[nr][nc][0] = true;
                if(now.chance == 1) visited[nr][nc][1] = true;
                Q.add(new Node(nr, nc, now.cost+1, now.chance));
            }
        }
        
        System.out.println(answer);
    }
    
    static class Node {
        int r, c, cost, chance;
        
        public Node (int r, int c, int cost, int chance){
            this.r = r;
            this.c = c;
            this.cost = cost;
            this.chance = chance;
        }
    }
}
