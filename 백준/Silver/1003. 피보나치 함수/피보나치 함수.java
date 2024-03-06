import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        
        list.add(0);
        list.add(1);
        for(int i=0; i<39; i++)
            list.add(list.get(i) + list.get(i+1));
        
        
        while(cnt-- > 0) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) sb.append("1 0\n");
            else sb.append(list.get(N-1) + " " + list.get(N) + "\n");
        }
        
        System.out.print(sb);
	}
}


