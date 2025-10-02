import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        Map<Integer, List<Integer>> edgeMap = new HashMap<>();
        Map<Integer, int[]> nodeInfoMap = new HashMap<>();
        List<Integer> startNodes = new ArrayList<>();

        for (int [] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            edgeMap.putIfAbsent(a, new ArrayList<>());
            edgeMap.putIfAbsent(b, new ArrayList<>());
            nodeInfoMap.putIfAbsent(a, new int[2]);
            nodeInfoMap.putIfAbsent(b, new int[2]);

            edgeMap.get(a).add(b);
            nodeInfoMap.get(a)[0]++;
            nodeInfoMap.get(b)[1]++;
        }


        // 생성 노드 찾기
        for (int key : nodeInfoMap.keySet()) {
            int[] nodeInfo = nodeInfoMap.get(key);
            // 나가는게 2개 이상이면서 들어오는게 없는 노드가 생성 노드
            if (nodeInfo[0] >= 2 && nodeInfo[1] == 0) {
                answer[0] = key;
                startNodes = edgeMap.get(key);
            }
        }

        // 찾기
        for (int node : startNodes) {
            int idx = dfs(node, answer, edgeMap, nodeInfoMap);
            answer[idx]++;
        }
        return answer;
    }


    static int dfs(int start, int[] answer, Map<Integer, List<Integer>> edgeMap, Map<Integer, int[]> nodeInfoMap) {
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        Q.add(start);
        visited.put(start, true);

        while(!Q.isEmpty()) {
            int now = Q.removeFirst();
            if (edgeMap.get(now).size() == 2) return 3;
            
            for (int nxt : edgeMap.get(now)) {
                if (visited.containsKey(nxt)) return 1;

                Q.add(nxt);
                visited.put(nxt, true);
            }
        }


        return 2; // 막대
    }
}