import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(st.nextToken()));
        list.add(Integer.parseInt(st.nextToken()));
        list.add(Integer.parseInt(st.nextToken()));
        Collections.sort(list);
        
        Object[] array = list.toArray();
        int x = (int)array[0];
        int y = (int)array[1];
        int z = (int)array[2];
        
        if(z < x+y) System.out.print(x+y+z);
        else System.out.print(2*(x+y)-1);
	}
}