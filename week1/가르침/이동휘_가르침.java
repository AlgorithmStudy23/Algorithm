package week1.가르침;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class 이동휘_가르침 {

    static int K, N, cnt;
    static boolean[] check;
    static ArrayList<HashSet<Character>> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (K < 5) {
            System.out.println(0);
            return;
        }
        check = new boolean[26];
        check['a'-'a'] = true; check['n'-'a'] = true; check['t'-'a'] = true;
        check['c'-'a'] = true; check['i'-'a'] = true;
        arr = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            char[] tmp2 = tmp.substring(4, tmp.length()-4).toCharArray();
            HashSet<Character> s = new HashSet<>();
            for (char c : tmp2) {
                s.add(c);
            }
            arr.add(s);
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
                dfs(cur + 1, idx+1);
                check[i] = false;
            }
        }

    }
    static int count() {
        int count = 0;
        loop:
        for (HashSet<Character> s : arr) {
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