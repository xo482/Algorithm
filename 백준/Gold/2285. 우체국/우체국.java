import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long sum = 0, total = 0, majority;
    static int[][] arr;
    static int N;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        for(int i=0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            total += arr[i][1];
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        majority = (total + 1) / 2;
        
        for(int i=0; i < N; i++){
            sum += arr[i][1];
            if(sum < majority) continue;
            
            System.out.print(arr[i][0]);
            break;
        }
    }
}