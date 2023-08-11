package week3.게임_개발;

import java.io.*;
import java.util.*;

public class 이동휘_게임_개발 {

    static boolean[] check;
    static ArrayList<Integer> times;
    static ArrayList<ArrayList<Integer>> prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        check = new boolean[n];
        times = new ArrayList<>(n);
        prev = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            times.add(time);

            ArrayList<Integer> arr = new ArrayList<>();
            while (true) {
                int cur = Integer.parseInt(st.nextToken()) - 1;
                if (cur < 0) break;

                arr.add(cur);
            }

            check[i] = (arr.size() == 0);
            prev.add(arr);
        }
        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf(dfs(i)));
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }

    static int dfs(int cur) {
        if (check[cur]) {
            return times.get(cur);
        }

        int max = 0;
        ArrayList<Integer> arr = prev.get(cur);
        for (int i : arr) {
            max = Math.max(max, dfs(i));
        }

        times.set(cur, times.get(cur) + max);
        check[cur] = true;
        return times.get(cur);
    }
}

