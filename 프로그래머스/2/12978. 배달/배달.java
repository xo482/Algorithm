import java.util.*;
class Solution {
    
    static List<Edge>[] list;
    static PriorityQueue<Node> Q = new PriorityQueue<>();
    static int[] distance;
    static int INF = 500001;
    static int answer = 0;
    
    public int solution(int N, int[][] road, int K) {
        list = new List[N+1];
        for(int i = 1; i < N+1; i++) list[i] = new ArrayList<>();
        for(int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];
            list[a].add(new Edge(b,c));
            list[b].add(new Edge(a,c));
        }
        distance = new int[N+1];
        Arrays.fill(distance, INF);
        
        
        Q.add(new Node(1, 0));
        distance[1] = 0;
        while(!Q.isEmpty()) {
            Node now = Q.poll();
            
            if(distance[now.v] < now.cost) continue;
            
            for(Edge nxt : list[now.v]) {
                if(distance[nxt.v] > distance[now.v] + nxt.cost) {
                    distance[nxt.v] = distance[now.v] + nxt.cost;
                    Q.add(new Node(nxt.v, distance[nxt.v]));
                }
            }
        }
        
        
        for(int d : distance) 
            if (d <= K) 
                answer++;
        return answer;
    }
    
    static class Node implements Comparable<Node> {
        int v, cost;
        
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static class Edge {
        int v, cost;
        
        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}