import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        int x_min , y_min, x_max, y_max;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        x_min = Integer.parseInt(st.nextToken());
        x_max = x_min;
        y_min = Integer.parseInt(st.nextToken());
        y_max = y_min;
        
        for(int i=1;i<cnt;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            if(x < x_min) x_min = x;
            if(x > x_max) x_max = x;
            if(y < y_min) y_min = y;
            if(y > y_max) y_max = y;
        }
        
        int result = (x_max - x_min) * (y_max - y_min);
        System.out.print(result);
	}
}