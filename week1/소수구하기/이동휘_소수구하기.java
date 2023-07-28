package week1.소수구하기;

import java.io.*;
import java.util.StringTokenizer;

public class 이동휘_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] num = new boolean[N+1];
        num[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (num[i]) {
                continue;
            }
            for (int j = i * i; j <= N; j += i) {
                num[j] = true;
            }
        }
        for (int i = M; i <= N; i++) {
            if (!num[i]) {
                bw.write(String.valueOf(i));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }
}
