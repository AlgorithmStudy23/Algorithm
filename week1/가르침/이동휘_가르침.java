package week1.가르침;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 이동휘_가르침 {

    static int K, N, cnt;
    static boolean[] check;
    static ArrayList<char[]> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        check = new boolean[26];
        check['a'-'a'] = true; check['n'-'a'] = true; check['t'-'a'] = true;
        check['c'-'a'] = true; check['i'-'a'] = true;
        arr = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            char[] s = tmp.substring(4, tmp.length()-3).toCharArray();
            arr.add(s);
        }
        if (K < 5) {
            System.out.println(0);
            return;
        }
        cnt = 0;
        dfs(5, 1);
        System.out.println(cnt);
    }
    static void dfs(int cur, int idx) {
        if (cur == K) {
            cnt = Math.max(cnt, count());
            return;
        }

        for (int i = idx; i < 26; i++) {
            if (!check[i]) {
                check[i] = true;
                dfs(cur + 1, i+1);
                check[i] = false;
            }
        }

    }
    static int count() {
        int count = 0;
        loop:
        for (char[] s : arr) {
            for(char c : s) {
                if (!check[c - 'a']) {
                    continue loop;
                }
            }
            count++;
        }
        return count;
    }
}