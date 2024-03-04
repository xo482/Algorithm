import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Scanner를 사용하여 두 정수 A와 B를 입력받기
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        // A-B 계산하여 출력
        int result = A - B;
        System.out.println(result);

        // Scanner 닫기
        scanner.close();
    }
}
