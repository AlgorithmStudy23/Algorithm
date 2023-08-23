package week4.증가하는_수;

import java.io.*;

public class 이동휘_증가하는_수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[][] dp = new int[80][11];
        for (int i = 1; i < 10; i++) {
            dp[0][i] = 1;
        }
        dp[0][10] = 10;
        for (int i = 1; i < 80; i++) {
            for (int j = 1; j < 10; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][10] += dp[i][j];
            }
        }
        loop:
        for (int i = 0; i < t; i++) {
            String n = br.readLine();
            for (int j = 0; j < n.length()-1; j++) {
                if (n.charAt(j) > n.charAt(j+1)) {
                    bw.write("-1");
                    bw.newLine();
                    continue loop;
                }
            }
            long res = 0;
            for (int j = 0; j < n.length()-1; j++) {
                res += dp[j][10];
            }


            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}

