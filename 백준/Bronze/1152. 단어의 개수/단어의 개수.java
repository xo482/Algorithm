import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();        
        
        StringTokenizer st = new StringTokenizer(s);
        int len = st.countTokens();
        
        System.out.print(len);
    }
}