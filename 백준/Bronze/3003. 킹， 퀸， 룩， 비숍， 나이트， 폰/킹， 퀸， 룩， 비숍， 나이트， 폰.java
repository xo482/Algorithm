import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] list = {1,1,2,2,2,8};
        
        for(int i =0; i < 6; i++) {
            int num = Integer.parseInt(st.nextToken());
            num = list[i] - num;
            System.out.print(num + " ");
        }
    }
}