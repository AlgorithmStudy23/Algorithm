package week3.뉴스_전하기;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 이동휘_뉴스_전하기 {

    static ArrayList<LinkedList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
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

        System.out.println(dfs(0) - 1);
    }
    static int dfs(int cur) {
        LinkedList<Integer> list = graph.get(cur);
        if (list.size() == 0) {
            return 1;
        }

        int max = list.size();
        int[] arr = new int[max];
        int idx = 0;
        for (int i : list) {
            arr[idx++] = dfs(i);
        }
        Arrays.sort(arr);
        int i = max-1;
        int time = 0;
        for (; i >= 0; i--) {
            max = Math.max(max, time++ + arr[i]);
        }

        return max + 1;
    }
}
