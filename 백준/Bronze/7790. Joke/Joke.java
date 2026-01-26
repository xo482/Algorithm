import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        // EOF까지 전부 읽음
        while ((line = br.readLine()) != null) {
            sb.append(line).append('\n');
        }

        String text = sb.toString();
        String[] arr = text.split("joke");

        System.out.println(arr.length - 1);
    }
}
