import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        Map<Integer, String> map = new HashMap<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
         
        map.put(s, "");
        q.add(s);
        
        if (s == t) {
            System.out.print(0);
            return;
        }
        if (t == 1) {
            System.out.print('/');
            return;
        }
        if (s < t && t % 2 == 1 && s % 2 == 0) {
            System.out.print(-1);
            return;
        }

       
        int INF = 1000000001;
        int mul_limit = (int) Math.sqrt(1000000000) + 1;
        while (!q.isEmpty()) {
            int now = q.removeFirst();
            //System.out.println(now);
            if (now == t) {
                System.out.print(map.get(now));
                return;
            }
            
            if (now < t) {
                if (t % 2 == 1 && now % 2 == 0) continue;
                if (now < mul_limit && !map.containsKey(now*now)) {
                    map.put(now*now, map.get(now) + "*");
                    q.add(now*now);
                }
                
                if (now * 2 < 1000000001 && !map.containsKey(now*2)) {
                    map.put(now*2, map.get(now) + "+");
                    q.add(now*2);
                }
            }
            
            if (!map.containsKey(1)) {
                map.put(1, "/");
                q.add(1);
            }
        }
        System.out.print(-1);
    }
}