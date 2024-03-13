 import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] list = new int[N];
        int max = 0, val=0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<N-2; i++){
            for(int j=i+1; j< N-1;j++){
                for(int k = j+1; k < N; k++) {
                    val = list[i] + list[j] + list[k];
                    if(max < val && val <= M) max = val;
                }
            }
        }
        
        System.out.print(max);
	}
}