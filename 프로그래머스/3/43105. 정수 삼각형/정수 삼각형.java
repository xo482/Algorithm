import java.util.Arrays;
class Solution {
    public int solution(int[][] triangle) {
        int N = triangle.length;
        for(int i = 1; i < N; i++) {
            int M = triangle[i].length;
            for(int j = 0; j < M; j++) {
                
                if (j == 0) { triangle[i][0] += triangle[i-1][0]; continue; }
                if (j == M-1) { triangle[i][M-1] += triangle[i-1][M-2]; continue; }
                
                triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
            }
        }
        
        return Arrays.stream(triangle[N-1]).max().getAsInt();
    }
}