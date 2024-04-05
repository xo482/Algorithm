import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int m;
    static int r;
    static int max;
    static Map<Integer, Integer> area;
    static Map<Integer, Boolean> visit;
    static int[][] roads;


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 지역의 개수
        m = Integer.parseInt(st.nextToken()); // 수색 범위
        r = Integer.parseInt(st.nextToken()); // 길의 개수
        max = 0;

        // 지역정보 : 지역번호, 지역의 아이템 수
        area = new HashMap<>();
        visit = new HashMap<>();

        // 길 정보 : 지역번호, 갈 수 있는 지역과 그 거리
        roads = new int[2*r][3];

        // 지역 정보 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            area.put(i + 1, Integer.parseInt(st.nextToken()));
            visit.put(i + 1, false);
        }

        // 길 정보 초기화
        for (int i = 0; i < 2*r; i+=2) {
            st = new StringTokenizer(br.readLine());
            roads[i][0] = Integer.parseInt(st.nextToken());
            roads[i][1] = Integer.parseInt(st.nextToken());
            roads[i][2] = Integer.parseInt(st.nextToken());

            roads[i + 1][0] = roads[i][1];
            roads[i + 1][1] = roads[i][0];
            roads[i + 1][2] = roads[i][2];
        }

        for (Integer id : area.keySet()) {
            int sum = search(id, m);
//            System.out.println("id = " + id);
//            System.out.println("sum = " + sum);

            for (Integer i : visit.keySet()) {
                visit.replace(i, false);
            }

            if (sum > max) max = sum;
        }

        System.out.println(max);
    }

    private static int search(int id, int len) {
        int sum = 0;
        if (!visit.get(id)){
            sum = area.get(id);
            visit.replace(id, true);
        }

        for (int[] road : roads) {
//            System.out.println("road = " + road[0] + ", " + road[1] + ", " + road[2]);
            if (road[0] == id && road[2] <= len) {
//                System.out.println(id + " -> " + road[1]);
                sum += search(road[1], len - road[2]);
            }
        }

        return sum;
    }
}