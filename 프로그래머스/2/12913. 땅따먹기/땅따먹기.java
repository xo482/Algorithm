import java.util.*;

class Solution {
    int solution(int[][] land) {
        int N = land.length;
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 4; j++) { 
                
                int max = 0;
                for (int k = 1; k < 4; k++) 
                    max = Math.max(max, land[i-1][(j+k)%4]);
                
                land[i][j] += max;
            }
        }
        
        return Math.max(Math.max(land[N-1][0], land[N-1][1]), Math.max(land[N-1][2], land[N-1][3]));
    }
}