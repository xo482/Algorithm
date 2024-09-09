import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String line = br.readLine();

        // 1.양 끝이 '_'인가?   2.문자열에 '__'이 포함되는가?   3.첫글자가 대문자 인가?전부 다 대문자인가?
        if (line.charAt(0) == '_' || line.charAt(line.length() - 1) == '_' ||
                line.contains("__") || line.charAt(0) <= 90) {
            System.out.println("Error!");
            return;
        }

        // 다 소문자인 경우에는 둘이 똑같음
        if (!line.contains("_") && line.equals(line.toLowerCase())) {
            System.out.println(line);
            return;
        }

        // 여기까지 온 애들은 자바인지 아닌지 판별하고 바꾸기만 하면됨

        // 파이썬인 경우
        if (line.contains("_")) {

            //근데 대문자가 포함되어 있는가?
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) <= 90) {
                    System.out.println("Error!");
                    return;
                }
            }

            String[] split = line.split("_");
            sb.append(split[0]);
            for (int i = 1; i < split.length; i++) {
                if (split[i].length() == 1) split[i] = split[i].toUpperCase();
                else split[i] = split[i].substring(0, 1).toUpperCase() + split[i].substring(1);
                sb.append(split[i]);
            }
        }
        // 자바인 경우
        else {
            for (int i = 0; i < line.length(); i++) {
                if (65 <= line.charAt(i) && line.charAt(i) <= 90)
                    sb.append("_").append((char)(line.charAt(i) + 32));
                else
                    sb.append(line.charAt(i));
            }
        }

        System.out.println(sb);
    }
}