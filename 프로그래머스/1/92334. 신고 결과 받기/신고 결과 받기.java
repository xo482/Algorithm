import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int len = id_list.length;
        int[] answer = new int[len];
        int[][] arr = new int[len][len];
        int index = 0;
        Map<String, Integer> map = new HashMap<>();

        // muzi:0, frodo:1, ...
        for (String name : id_list) {
            map.put(name, index++);
        }
        // 신고 현황판 만들기
        for (String str : report) {
            String[] each = str.split(" ");
            arr[map.get(each[0])][map.get(each[1])] = 1;
        }
        // 신고 수 검사
        for (int j = 0; j < len; j++) {
            int sum = 0;
            for (int i = 0; i < len; i++)
                sum += arr[i][j];

            // 정지
            if (sum >= k)
                for (int i = 0; i < len; i++)
                    if (arr[i][j] == 1) answer[i]++;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k=2;
        int[] result = solution.solution(id_list, report, k);
    }
}

