package week2.소수_찾기;

public class 이동휘_소수_찾기 {

    static char[] numbers;
    static int len, res;
    static final int MAX = 10000000;
    static boolean[] num, check;

    public int solution(String Numbers) {
        numbers = Numbers.toCharArray();
        len = numbers.length;
        num = new boolean[MAX];
        num[0] = true;
        num[1] = true;
        for(int i = 2; i * i < MAX; i++) {
            if(num[i]) continue;
            for(int j = i * i; j < MAX; j += i) {
                num[j] = true;
            }
        }
        res = 0;
        check = new boolean[len];
        dfs(0);
        return res;
    }

    static void dfs(int n) {
        if(!num[n]) {
            num[n] = true;
            res++;
        }

        for(int i = 0; i < len; i++) {
            if(!check[i] && (n != 0 || numbers[i] != '0')) {
                check[i] = true;
                n = n*10 + (numbers[i] - '0');
                dfs(n);
                check[i] = false;
                n /= 10;
            }
        }
    }
}
