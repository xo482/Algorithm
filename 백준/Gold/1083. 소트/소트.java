import java.io.*;
import java.util.*;

public class Main {
    static int n, s;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) list.add(Integer.parseInt(st.nextToken()));
        s = Integer.parseInt(br.readLine());

        for(int i=0; i<n-1 && s>0; i++){
            int maxPos = i;
            for(int j=i+1; j<n && j-i<=s; j++){
                if(list.get(j) > list.get(maxPos)){
                    maxPos = j;
                }
            }
            if(maxPos == i) continue;
            int temp = list.remove(maxPos);
            list.add(i, temp);
            s -= (maxPos - i);
        }
        for(int i=0; i<n; i++) sb.append(list.get(i)).append(" ");
        System.out.print(sb);
    }
}