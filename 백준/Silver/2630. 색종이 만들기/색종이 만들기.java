import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int blue_cnt=0;
    static int white_cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        // init
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        quest(0,N,0,N);

        System.out.println(white_cnt);
        System.out.println(blue_cnt);
    }

    public static void quest(int start_i, int end_i, int start_j, int end_j) {

        if (!check(start_i, end_i, start_j, end_j)) {

            int mid_i = (start_i + end_i) / 2;
            int mid_j = (start_j + end_j) / 2;

            quest(start_i, mid_i, start_j, mid_j); // 2 사분면
            quest(mid_i, end_i, start_j, mid_j); // 3 사분면
            quest(mid_i, end_i, mid_j, end_j);
            quest(start_i, mid_i, mid_j, end_j);

        }
    }

    // 해당 범위가 같은 값으로만 이루어져 있으면 해당하는 카운터를 증가시키고
    // true 를 리턴하는 함수
    public static boolean check(int start_i, int end_i, int start_j, int end_j) { // 0 : 하얀색, 1 : 파란색

        int color = arr[start_i][start_j];

        for (int i = start_i; i < end_i; i++) {
            for (int j = start_j; j < end_j; j++) {
                if(arr[i][j] != color) return false;
            }
        }

        if (color == 0) white_cnt++;
        else blue_cnt++;

        return true;
    }

}
