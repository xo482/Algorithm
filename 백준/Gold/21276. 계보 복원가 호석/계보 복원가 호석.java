import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static Map<String, Integer> inDegreeMap = new HashMap<>(); // 진입차수, 조상의 수
    static Map<String, List<String>> descendantMap = new HashMap<>(); // 후손의 리스트를 가지는 map
    static Map<String, List<String>> childMap = new HashMap<>(); // 직계자식의 리스트를 가지는 map
    static Map<String, Boolean> visitedMap = new HashMap<>(); // 방문처리 map
    static List<String> topList = new ArrayList<>();
    static ArrayDeque<String> Q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String name = st.nextToken();
            descendantMap.put(name, new ArrayList<>());
            childMap.put(name, new ArrayList<>());
            visitedMap.put(name, false);
            inDegreeMap.put(name, 0);
        }

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent = st.nextToken();

            descendantMap.get(parent).add(child);
            inDegreeMap.put(child, inDegreeMap.getOrDefault(child, 0)+1);
        }

        for (String name : inDegreeMap.keySet()) {
            if (inDegreeMap.get(name) == 0 && !visitedMap.get(name)) {
                topList.add(name);
                Q.addLast(name);
                visitedMap.put(name, true);

                while (!Q.isEmpty()) {
                    String now = Q.removeFirst();

                    for (String next : descendantMap.get(now)) {
                        inDegreeMap.put(next, inDegreeMap.get(next) - 1);
                        if (inDegreeMap.get(next) == 0) {
                            visitedMap.put(next, true);
                            Q.addLast(next);
                            childMap.get(now).add(next);
                        }
                    }
                }
            }
        }

        Collections.sort(topList);
        sb.append(topList.size()).append("\n");
        for (String name : topList) {
            sb.append(name).append(" ");
        }
        sb.append("\n");

        List<String> list = new ArrayList<>(childMap.keySet().stream().collect(Collectors.toList()));
        Collections.sort(list);
        for (String name : list) {
            sb.append(name).append(" ").append(childMap.get(name).size());
            Collections.sort(childMap.get(name));
            for (String s : childMap.get(name)) {
                sb.append(" ").append(s);
            }
            sb.append("\n");
        }


        System.out.print(sb);
    }
}
