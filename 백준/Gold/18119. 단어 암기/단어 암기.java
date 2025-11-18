import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static List<Integer>[] list;
    static int[] words;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        words = new int[N];
        list = new List[26];
        for (int i = 0; i < 26; i++) list[i] = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            visited = new boolean[26];
            for (int j = 0; j < word.length(); j++) {
                int alphabet = word.charAt(j) - 'a';
                if (visited[alphabet]) continue;
                
                visited[alphabet] = true;
                list[alphabet].add(i);
            }
        }

        int answer = N;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int x = st.nextToken().charAt(0) - 'a';

            if (o == 1) {
                for (int word_idx : list[x]) {
                    if (words[word_idx] == 0) answer--;
                    words[word_idx]++;
                }
            }
            if (o == 2) {
                for (int word_idx : list[x]) {
                    words[word_idx]--;
                    if (words[word_idx] == 0) answer++;
                }
            }

            sb.append(answer).append('\n');
        }

        System.out.print(sb);
    }
}
