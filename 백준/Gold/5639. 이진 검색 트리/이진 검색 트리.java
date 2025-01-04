import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr = new int[1000000];

    public static void main(String[] args) throws IOException {

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals("")) break;

            root.insert(Integer.parseInt(input));
        }

        System.out.print(root.postOrder());
    }

    static class Node {
        int num;
        Node left, right;

        public Node(int num) {
            this.num = num;
        }

        public void insert(int num) {
            if (this.num > num) {
                if (left == null) left = new Node(num);
                else left.insert(num);
            }
            else {
                if (right == null) right = new Node(num);
                else right.insert(num);
            }
        }

        public String postOrder(){
            StringBuilder sb = new StringBuilder();

            if (left != null) sb.append(left.postOrder());
            if (right != null) sb.append(right.postOrder());
            sb.append(num).append("\n");

            return sb.toString();
        }
    }
}