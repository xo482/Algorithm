import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;
        
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        
        for (int i=0; i< N; i++) {
            map.put(br.readLine(),0);
        }
        
        for (int i=0; i< M; i++) {
            if(map.containsKey(br.readLine())) cnt++;
        }

        System.out.print(cnt);
    }
}