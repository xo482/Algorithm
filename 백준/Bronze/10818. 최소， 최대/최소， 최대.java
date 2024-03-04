import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max, min, N;

       
        Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
            
        max = -1000001;
        min = 1000001;

        while (st.hasMoreTokens()) {
            N = Integer.parseInt(st.nextToken());

            if (N > max)
                max = N;
            if (N < min)
                min = N;
        }
        
		System.out.println(min + " " + max);
    }
}
