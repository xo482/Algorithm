import java.io.*;

public class Main {

    static int N;
    static int answer=0;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1]; // 값이 0이면 비어있음을 의미한다. 인덱스는 그 라인, 값은 그 라인 어디에 퀸을 놓았는지를 의미한다.

        tracking(1);
        System.out.println(answer);
    }

    private static void tracking(int now) {
        if (now == N+1) {
            answer++;
            return;
        }

        for (int i = 1; i <= N; i++) {
            boolean flag = false;

            for (int j = 1; j < now; j++) {
                int x = now-j;
                int y = Math.abs(i - arr[j]);
                if (i == arr[j] || x==y){
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                arr[now] = i;
                tracking(now+1);
            }
        }
    }


}