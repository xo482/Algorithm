import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N;
    static PriorityQueue<Building> pq = new PriorityQueue<>();
    static TreeMap<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2 - o1);
    static List<Building> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            pq.add(new Building(left, h));
            pq.add(new Building(right, -h));
        }

        map.put(0, 0);
        list.add(new Building(0, 0));
        while (!pq.isEmpty()) {
            Building now = pq.poll();

            if (now.h > 0) map.put(now.h, map.getOrDefault(now.h, 0) + 1);
            else {
                int key = -now.h;
                int val = map.get(key);

                if (val == 1) map.remove(key);
                if (val > 1) map.put(key, val - 1);
            }

            if (map.firstKey() == list.get(list.size()-1).h) continue;
            list.add(new Building(now.p, map.firstKey()));
        }

        for (int i = 1; i < list.size(); i++) {
            Building now = list.get(i);
            sb.append(now.p).append(' ').append(now.h).append(' ');
        }
        System.out.println(sb);
    }

    static class Building implements Comparable<Building>{
        int p, h;

        public Building(int p, int h) {
            this.p = p;
            this.h = h;
        }


        @Override
        public int compareTo(Building o) {
            if (this.p == o.p) return o.h - this.h;
            return this.p - o.p;
        }
    }
}