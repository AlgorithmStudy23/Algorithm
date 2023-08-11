package week3.뉴스_정하기;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 이동휘_뉴스_정하기 {

    static ArrayList<LinkedList<Integer>> graph;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        for (int i = 1; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            graph.get(cur).add(i);
        }
        int[] arr = dfs(0);
        for (int i = 50; i >= 1; i--) {
            if (arr[i] > 0) {
                System.out.println(i);
                return;
            }
        }
    }
    static int[] dfs(int cur) {
        LinkedList<Integer> list = graph.get(cur);
        if (list.size() == 0) {
            return new int[]{0, 1};
        }
        int[] num = new int[51];
        for (int i : list) {
            int idx = 0;
            for (int j : dfs(i)) {
                num[idx++] += j;
            }
        }
        for (int i = 1; i < 50; i++) {
            num[i+1] += num[i] / 2;
            num[i] %= 2;
        }
        return num;
    }
}
