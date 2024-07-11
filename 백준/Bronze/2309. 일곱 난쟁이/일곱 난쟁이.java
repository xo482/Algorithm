import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[9];
        int sum = 0;
        int[] criminal = new int[2];

        // Input phase
        for (int i = 0; i < 9; i++) {
            while (!sc.hasNextInt()) {
                sc.next(); // consume non-integer input
                System.out.println("Invalid input. Please enter an integer.");
            }
            input[i] = sc.nextInt();
            sum += input[i];
        }

        int sub = sum - 100;
        boolean found = false;

        // Finding criminal numbers
        for (int j = 0; j < 9 && !found; j++) {
            for (int k = j + 1; k < 9; k++) {
                if (input[j] + input[k] == sub) {
                    criminal[0] = input[j];
                    criminal[1] = input[k];
                    found = true;
                    break;
                }
            }
        }

        // Output phase
        Arrays.sort(input);
        for (int p = 0; p < 9; p++) {
            if (input[p] != criminal[0] && input[p] != criminal[1]) {
                System.out.println(input[p]);
            }
        }
    }
}
