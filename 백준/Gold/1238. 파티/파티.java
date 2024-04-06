import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N; // 마을 수
    static int M; // 도로 수
    static int X; // 파티하는 마을
    static int[][] arr;
    static boolean[] visit;
    private static final int INF = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;
        arr = new int[N][N];
        visit = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] =
                    Integer.parseInt(st.nextToken());
        }

//        printArr();


        for (int i = 0; i < N; i++) {
//            System.out.println("00000000000000000000000000000000000000000000");
            dijkstra(i);
            for (int j = 0; j < N; j++) {
                visit[j] = false;
            }
        }

//        printArr();

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (X == i) continue;
            if (max < arr[i][X] + arr[X][i]) max = arr[i][X] + arr[X][i];
        }
        System.out.println(max);
    }

    private static void dijkstra(int start) {
        visit[start] = true;

        int index = seachMin(start);


        while(index != -1) {
//            System.out.println("index = " + index);
            visit[index] = true;
            for (int i = 0; i < N; i++) {

                if (start == i) continue;

                if (arr[start][i] > arr[start][index] + arr[index][i]
                        && arr[start][index] != 0
                        && arr[index][i] != 0) {

//                    System.out.println(start + " " + index + " " + i);

//                    System.out.println(arr[start][i] +" = " + arr[start][index] + " + " + arr[index][i]);
                    arr[start][i] = arr[start][index] + arr[index][i];

//                    System.out.println("arr[start][i] = " + arr[start][i]);
                }
            }
            index = seachMin(start);

        }
    }

    // 그 노드에서 갈 수 있는 노드 중 최단 거리인 노드의 인덱스를 반환한다.
    // 이미 모든 노드를 방문 했다면 -1을 반환한다.
    private static int seachMin(int start) {
        int min = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < N; i++) {
            if (!visit[i] && arr[start][i] < min) {
                min = arr[start][i];
                index = i;
            }
        }

        return index;
    }

    private static void printArr() {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
