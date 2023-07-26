package week1.암호코드;

import java.io.*;

public class 이동휘_암호코드 {

    static final int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int len = num.length();
        int[] dp = new int[len+1];
        dp[0] = 1;
        dp[1] = 1;

        if (num.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        for(int i = 2; i <= len; i++) {
            String cur = num.substring(i-2, i);
            int curNum = Integer.parseInt(cur);
            if ((cur.charAt(0) > '2' && cur.charAt(1) == '0') || curNum == 0) {
                dp[len] = 0;
                break;
            }
            if (curNum >= 10 && curNum <= 26) {
                dp[i] += dp[i-2];
            }
            if (cur.charAt(1) != '0') {
                dp[i] += dp[i-1];
            }
            dp[i] %= MOD;
        }
        System.out.println(dp[len]);
    }
}