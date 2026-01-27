import java.util.*;
import java.io.*;

public class Main {
    static int n, k; // n: 맵의 길이, k: 최대 점프 길이
    static int map[][]; // 게임 맵을 나타내는 2차원 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 맵의 길이 읽기
        k = Integer.parseInt(st.nextToken()); // 최대 점프 길이 읽기
        map = new int[2][n]; // 2행 n열로 맵 초기화

        // 두 개의 맵 행 읽기
        for (int i = 0; i < 2; i++) {
            String str = br.readLine(); // 현재 행을 문자열로 읽기
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0'; // 문자를 정수(0 또는 1)로 변환
            }
        }

        // 맵에서 탈출할 수 있는지 확인
        if (go()) {
            System.out.println(1); // 탈출 가능하면 1 출력
        } else {
            System.out.println(0); // 탈출 불가능하면 0 출력
        }
    }

    static boolean go() {
        boolean visit[][] = new boolean[2][n]; // 방문한 위치를 추적하는 2차원 배열
        int dc[] = {-1, 1, k}; // 가능한 열 이동: 왼쪽, 오른쪽, 점프
        Queue<int[]> q = new LinkedList<int[]>(); // BFS를 위한 큐
        q.add(new int[] {0, 0, 0}); // (행 0, 열 0, 시간 0)에서 시작
        visit[0][0] = true; // 시작 위치를 방문한 것으로 표시

        // BFS 수행
        while (!q.isEmpty()) {
            int cur[] = q.poll(); // 현재 위치와 시간을 가져옴
            for (int i = 0; i < 3; i++) {
                int nc = cur[1] + dc[i]; // 새로운 열 인덱스 계산
                int nr = cur[0]; // 행은 처음에 그대로 유지
                int time = cur[2]; // 현재 시간 가져오기

                if (i == 2) {
                    nr = (cur[0] == 1) ? 0 : 1; // 점프 시 행을 전환
                }

                if (nc >= n) {
                    return true; // 성공적으로 맵을 탈출
                }
                if (nc <= time) continue; // 뒤로 점프하거나 이미 방문한 위치로 점프할 수 없음
                if (visit[nr][nc]) continue; // 이미 방문한 위치이면 건너뛰기
                if (map[nr][nc] == 0) continue; // 점프할 수 없는 셀에는 착지할 수 없음

                visit[nr][nc] = true; // 새로운 위치를 방문한 것으로 표시
                q.add(new int[] {nr, nc, time + 1}); // 새로운 위치를 큐에 추가
            }
        }
        return false; // 맵을 탈출할 수 없음
    }
}