import java.util.*;
import java.io.*;

class Solution {
    public String solution(long n, String[] bans) {
        long real_n = n;
        long[] arr = new long[bans.length];
        for (int i = 0; i < arr.length; i++) arr[i] = getLong(bans[i]);
        Arrays.sort(arr);

        long s = 0;
        long e = n + arr.length + 1;

        while (s + 1 < e) {
            long mid = (s + e) / 2;

            long cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > mid) break;
                cnt++;
            }

            if (mid - cnt >= real_n) {
                e = mid;
            } else {
                s = mid;
            }
        }

        long ans = e;
        while (!check(ans, arr)) ans++;
        return getString(ans);
    }

    static boolean check(long n, long[] arr) {
        return Arrays.binarySearch(arr, n) < 0;
    }
    
    static String getString(long pos) {
        StringBuilder sb = new StringBuilder();

        while (pos > 0) {
            pos--;
            int r = (int)(pos % 26);
            sb.append((char)('a' + r));
            pos /= 26;
        }

        return sb.reverse().toString();
    }


    static long getLong(String s) {
        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int x = s.charAt(i) - 'a' + 1; // 1~26
            sum = sum * 26 + x;
        }
        return sum;
    }
}

// 0이 없는, 1~26으로 이루어진 26진법임
// 그래서 -1으로 범위를 0~25로 가지게 해줘서 계산함
// 26진법의 0~25 범위를 a~z로 표현하는거임