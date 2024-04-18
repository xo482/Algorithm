import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 101;
        int[] rank = new int[n+1]; // 공의 개수 배열
        int[] inDegree = new int[n+1]; // 진입차수 배열
        List<List<Integer>> adj = new ArrayList<>();
        ArrayDeque<Integer> Q = new ArrayDeque<>();
        
        //== 초기화 ==//
        
        for (int i = 0; i <= n; i++) { 
            adj.add(new ArrayList<>()); // 2차원 리스트 초기화
            rank[i] = 1; // 모든 노드는 공을 하나씩 들고 시작한다.
        }
        
        
        for(int[] connection : wires){
            int v1 = connection[0];
            int v2 = connection[1];
            
            adj.get(v1).add(v2); // 2차원 리스트 값 삽입
            adj.get(v2).add(v1);
            
            inDegree[v1]++; // 진입차수 배열 초기화
            inDegree[v2]++;
        }
        
        // 진입차수가 1인 노드들을 큐에 삽입
        for(int i=1; i < n+1; i++)
            if (inDegree[i] == 1)
                Q.addLast(i);
        
        
        // 위상 정렬 로직 시작
        while(!Q.isEmpty()) {
            
            int now = Q.removeFirst();
            
            // 다른 노드들의 공의 합과 나의 공의 차이를 기록한다.
            answer = Math.min(answer, Math.abs(n - 2*rank[now]));
            
            // 지금 node와 연결되어 있는 노드의 rank를 지금 노드가 가지고 있는 공의 개수만큼 증가시키고 
            // inDegree는 1 감소시킨다.
            for (int next : adj.get(now)) {
                rank[next] += rank[now];
                inDegree[next]--;
                
                // 만약 inDegree가 1이 되었다면 힙에 삽입한다.
                if (inDegree[next] == 1)
                    Q.addLast(next);
            }
        }
        
        
        return answer;
    }
}