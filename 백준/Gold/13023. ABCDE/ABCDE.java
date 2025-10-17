import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M;
    static List<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N];
        list = new List[N];
        for(int i = 0; i < N; i++) list[i] = new ArrayList<>();
        
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            list[a].add(b);
            list[b].add(a);
        }
        
        boolean answer = false;
        for(int i = 0; i < N; i++) {
            
            visited[i] = true;
            answer = tracking(i, 1);
            visited[i] = false;
            
            if (answer) break;
        }
        
        
        if (answer) System.out.print(1);
        else System.out.print(0);
    }
    
    static boolean tracking(int a, int depth) {
        
        if (depth == 5) {
            return true;
        }
        
        for(int b : list[a]) {
            if (visited[b]) continue;
        
            visited[b] = true;
            boolean answer = tracking(b, depth + 1);
            visited[b] = false;
        
            if (answer) return true;
        }
        
        return false;
    
    }
}