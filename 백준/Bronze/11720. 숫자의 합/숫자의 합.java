import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        String numbers = br.readLine();
        int total = 0;
        
        for(int i = 0; i < length; i++) {
            total += ((int) numbers.charAt(i) - 48);
        }
        
        System.out.print(total);
    }
}