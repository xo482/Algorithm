import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] lines) {
        PriorityQueue<long[]> list = new PriorityQueue<>((o1, o2) -> (int) (o1[0] - o2[0]));
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> (int) (o1[1] - o2[1]));
        
        for (String line : lines) {
            long[] arr = trans(line);
            list.add(arr);
        }

        
        int max = 0;
        while (!list.isEmpty()) {
            long[] now = list.poll();
            System.out.println(now[0] + " " + now[1]);
            
            while (!pq.isEmpty()) {
                if (pq.peek()[1] + 1000 > now[0]) break;
                
                pq.poll();
            }
            
            System.out.println(max +" "+pq.size());
            
            pq.add(now);
            max = Math.max(max, pq.size());
            
        }

        return max;
    }

    static long[] trans(String s) {
        StringTokenizer st = new StringTokenizer(s);
        st.nextToken();
        String[] split = st.nextToken().split(":");
        Double d_time = 3600 * Integer.parseInt(split[0])
                + 60 * Integer.parseInt(split[1])
                + Double.parseDouble(split[2]);
        
        long time = (long) (d_time * 1000);
        
        
        String pts = st.nextToken();
        pts =pts.substring(0, pts.length() - 1);
        Double d_pt = Double.parseDouble(pts);
        long pt = (long) (d_pt * 1000);
        pt -= 1;

        return new long[]{time - pt, time};
    }
}