import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int num;
        
        num = Integer.parseInt(st.nextToken()) % 10;
        sum += num * num;
        num = Integer.parseInt(st.nextToken()) % 10;
        sum += num * num;
        num = Integer.parseInt(st.nextToken()) % 10;
        sum += num * num;
        num = Integer.parseInt(st.nextToken()) % 10;
        sum += num * num;
        num = Integer.parseInt(st.nextToken()) % 10;
        sum += num * num;
        
        System.out.print(sum%10);
	}
}
