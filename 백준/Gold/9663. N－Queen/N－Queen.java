import java.io.*;

public class Main {

    static int N;
    static int[] cols;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cols = new int[N];

        queen(0);

        System.out.println(cnt);
    }

    private static void queen(int index) {
        if (index == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            cols[index] = i; //사람을 일단 i번째에 세우고

            // 그 다음에 문제 없는지 확인
            if (check(index))
                // 문제 없으면 다음 사람(다음 가로)
                queen(index+1);
        }
    }

    private static boolean check(int index) {

        //세로가 겹치는 애들이 있는지 i 번째 사람과 index번째 사람이 같은 줄에 서있는지 확인
        // 기울기가 1혹은 -1인지 확인
        for (int i = 0; i < index; i++) {
            if (cols[i] == cols[index] || Math.abs(index - i) == Math.abs(cols[index] - cols[i]))
                return false;
        }
        return true;
    }


}