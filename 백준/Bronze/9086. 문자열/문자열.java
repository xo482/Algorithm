import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(br.readLine());
        String str;
        String start, end;
        
        for(int i = 0; i< loop; i++){
            str = br.readLine();
            start = String.valueOf(str.charAt(0));
            end = String.valueOf(str.charAt(str.length() - 1));
            
            System.out.println(start + end);
        }
    }
}