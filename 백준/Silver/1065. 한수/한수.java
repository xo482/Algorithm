import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N / 100 == 0) System.out.print(N);
        else{
            int cnt = 99;
            for(int i=100; i <= N; i++){
                int x = i/100 - i/10%10;
                int y = i/10%10 - i % 10;
                if(x == y) cnt++;
            }
            System.out.print(cnt);
        }
	}
}