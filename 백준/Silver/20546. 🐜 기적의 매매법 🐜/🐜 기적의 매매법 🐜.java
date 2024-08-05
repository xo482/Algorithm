import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int M = Integer.parseInt(br.readLine());
        Person person1 = new Person(M, 0);
        Person person2 = new Person(M, 0);

        int[] list = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++) list[i] = Integer.parseInt(st.nextToken());


        for (int i = 0; i < 14; i++) {
            if (list[i] <= person1.balance) {
                person1.cnt += person1.balance / list[i];
                person1.balance = person1.balance % list[i];
            }
        }

        int yesterday = list[0];
        int increaseCnt = 0;
        int decreaseCnt = 0;
        for (int i = 1; i < 14; i++) {
            if (yesterday > list[i]) {
                decreaseCnt++;
                increaseCnt = 0;
            } else if (yesterday < list[i]) {
                increaseCnt++;
                decreaseCnt = 0;
            } else {
                increaseCnt = 0;
                decreaseCnt = 0;
            }

            if (increaseCnt >= 3) {
                person2.balance += person2.cnt * list[i];
                person2.cnt = 0;
            }
            if (decreaseCnt >= 3) {
                if (list[i] <= person2.balance) {
                    person2.cnt += person2.balance / list[i];
                    person2.balance = person2.balance % list[i];
                }
            }

            yesterday = list[i];
        }

        if (person1.balance + person1.cnt * list[13] > person2.balance + person2.cnt * list[13]) System.out.print("BNP");
        else if (person1.balance + person1.cnt * list[13] < person2.balance + person2.cnt * list[13]) System.out.print("TIMING");
        else System.out.print("SAMESAME");
    }

    static class Person {
        int balance;
        int cnt;

        public Person(int balance, int cnt) {
            this.balance = balance;
            this.cnt = cnt;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }
    }
}