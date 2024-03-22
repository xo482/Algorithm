import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];

        // init
        for (int i = 0; i < N; i++) {
            String[] information = br.readLine().split(" ");
            Member member = new Member();
            member.age = Integer.parseInt(information[0]);
            member.name = information[1];
            members[i] = member;
        }

        // sort
        Arrays.sort(members, (m1, m2) -> {return m1.age - m2.age;});

        // print
        for (Member member : members) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }

        System.out.print(sb);
    }

    static class Member {
        public int age;
        public String name;
    }
}
