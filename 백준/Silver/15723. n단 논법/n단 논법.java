import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        list = new List[27];
        for(int i = 0; i < 27; i++) list[i] = new ArrayList<>();
        
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int to = st.nextToken().charAt(0) - 'a';
            
            list[from].add(to);
        }
        
        M = Integer.parseInt(br.readLine());
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int to = st.nextToken().charAt(0) - 'a';
            
            char c = tracking(from, to);
            sb.append(c).append("\n");
        }
        
        System.out.print(sb);
    }
    
    static char tracking(int from, int to) {
        
        for(int nxt : list[from]) {
            if (nxt == to) return 'T';
            return tracking(nxt, to);
        }
        
        return 'F';
    }
}