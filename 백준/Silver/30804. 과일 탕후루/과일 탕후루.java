import java.io.*;
import java.util.*;

// 투포인터를 이용해서 전체 배열 arr에서 2개의 숫자로 구성되는 부분배열의 최대길이를 구해야함
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int[] arr;
    static int[] type; // 부분배열 구성을 나타냄 , 인덱스는 과일의 종류,원소는 그 과일의 개수

    public static void main(String[] args) throws IOException {
        type = new int[10];
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int startIdx = 0;
        int endIdx = 0;
        int typeCnt = 0;
        int max = 0;

        for (; endIdx < N; endIdx++) { // 종류를 검사해서 3종류가 되면 2종류가 될때까지 반복문을 통해 start를 증가시킨다.
            if (type[arr[endIdx]] == 0) typeCnt++;
            type[arr[endIdx]] += 1;

            while (typeCnt > 2){
                type[arr[startIdx]]--;
                if (type[arr[startIdx]] == 0) typeCnt--;
                startIdx++;
            }

            max = Math.max(max, endIdx-startIdx+1); // 그 길이를 구해서 최댓값과 비교하고 end를 증가시킨다.
        }
        
        System.out.print(max);
    }
}