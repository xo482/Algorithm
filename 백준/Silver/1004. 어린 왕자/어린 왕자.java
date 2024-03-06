import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start_x = Integer.parseInt(st.nextToken());
            int start_y = Integer.parseInt(st.nextToken());
            int end_x = Integer.parseInt(st.nextToken());
            int end_y = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            
            while(n-- > 0) {
                st = new StringTokenizer(br.readLine());
                int planet_x = Integer.parseInt(st.nextToken());
                int planet_y = Integer.parseInt(st.nextToken());
                int radian = Integer.parseInt(st.nextToken());
                Double start_distance = Math.sqrt(Math.pow(planet_x - start_x, 2) + Math.pow(planet_y - start_y, 2));
                Double end_distance = Math.sqrt(Math.pow(planet_x - end_x, 2) + Math.pow(planet_y - end_y, 2));
                
                if(radian > start_distance) cnt++;
                if(radian > end_distance) cnt++;
                if(radian > start_distance && radian > end_distance) cnt -= 2;
            }
            
            System.out.println(cnt);
        }
	}
}