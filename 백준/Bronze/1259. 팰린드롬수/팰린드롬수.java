import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder inverter;

        while (num != 0) {
            inverter = new StringBuilder();
            if(num == Integer.parseInt(inverter.append(num).reverse().toString()))
                sb.append("yes\n");
            else sb.append("no\n");

            num = Integer.parseInt(br.readLine());
        }

        System.out.println(sb);
    }
}
