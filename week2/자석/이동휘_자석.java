package week2.자석;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class 이동휘_자석 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            arr1[i] = cur + (K * i);
            arr2[i] = cur + (K * (N-1-i));
        }

        Stack<int[]> stack1 = new Stack<>();
        Stack<int[]> stack2 = new Stack<>();
        stack1.add(new int[]{arr1[N-1], N-1});
        stack2.add(new int[]{arr2[0], 0});
        for (int i = N-2, j = 1; i >= 0; i--, j++) {
            if (stack1.peek()[0] > arr1[i]) {
                stack1.add(new int[]{arr1[i], i});
            }
            if (stack2.peek()[0] > arr2[j]) {
                stack2.add(new int[]{arr2[j], j});
            }
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int i = 0,j = N-1; i < N-1; i++, j--) {
            while (stack1.peek()[1] <= i) {
                stack1.pop();
            }
            while (stack2.peek()[1] >= j) {
                stack2.pop();
            }
            max1 = Math.max(max1, arr1[i] - stack1.peek()[0]);
            max2 = Math.max(max2, arr2[j] - stack2.peek()[0]);
        }

        System.out.println(Math.max(max1, max2));
    }
}
