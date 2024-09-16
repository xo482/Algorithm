import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static int n,m;
        
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        for(int i = 0; i <= n; i++) arr[i] = i;
        
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());
            int cal = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            if(cal == 0){
                int pa = findParent(a);
                int pb = findParent(b);
                arr[pb] = pa;
            }
            if(cal == 1){
                if(findParent(a) == findParent(b)) sb.append("YES\n");
                else sb.append("NO\n");
            }
        }
        
        System.out.print(sb);
    }
    
    private static int findParent(int n){
        if(n == arr[n]) return n;
        return arr[n] = findParent(arr[n]);
    }
}