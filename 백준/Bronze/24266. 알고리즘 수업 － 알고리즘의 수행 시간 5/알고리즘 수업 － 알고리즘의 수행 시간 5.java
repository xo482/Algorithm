import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long x = Integer.parseInt(br.readLine());
        System.out.print((x*x*x) + "\n3");
    }
}