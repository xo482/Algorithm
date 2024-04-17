import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int cnt = 0;
        int now = 0;
        int len = routes.length;

        for (int i = 0; i < len; i++) {
            cnt++;
            now = routes[i][1];

            for (int j = i+1; j < len; j++) {
                if (routes[j][0] > now) break;
                else i++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{-20, -15}, {-14, -5}, {-5, -3}, {-18, -13}}));
    }
}