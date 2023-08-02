package week1.가르침;

import java.io.*;
import java.util.*;

public class 이동휘_가르침2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<List<Character>> arr = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            char[] tmp = br.readLine().toCharArray();
            int len = tmp.length - 4;
            List<Character> list = new LinkedList<>();
            for (int j = 4; j < len; j++) {
                char c = tmp[j];
                if (c > 'a' && c < 'c') {
                    list.add((char) (c-1));
                } else if (c > 'c' && c < 'i') {
                    list.add((char) (c-2));
                } else if (c > 'i' && c < 'n') {
                    list.add((char) (c-3));
                } else if (c > 'n' && c < 't') {
                    list.add((char) (c-4));
                } else if (c > 't') {
                    list.add((char) (c-5));
                }
            }

            arr.add(list);
        }

        if (K < 5) {
            System.out.println(0);
            return;
        }

        int res = 0;

        for (int i = 0; i < (1 << 21); i++) {
            int cnt = 0;
            boolean[] check = new boolean[21];
            for (int j = 0; j < 21; j++) {
                if ((i & (1 << j)) == 0) {
                    check[j] = true;
                    cnt++;
                }
            }

            if (cnt != K-5) {
                continue;
            }
            int count = 0;
            loop:
            for (List<Character> set : arr) {
                for (char s : set) {
                    if (!check[s-'a']) {
                        continue loop;
                    }
                }
                count++;
            }
            res = Math.max(res, count);
        }
        System.out.println(res);
    }

}