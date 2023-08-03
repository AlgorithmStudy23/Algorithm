package week2.상담원_인원;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 이동휘_상담원_인원 {


    static int[][] reqs;
    static int[] maximum;
    static Integer[][] memo;
    static int k, n, res;

    public int solution(int K, int N, int[][] Reqs) {
        k = K; n = N;
        reqs = Reqs;
        maximum = new int[k+1];
        memo = new Integer[k+1][20];
        for(int[] i : reqs) {
            maximum[i[2]]++;
        }

        int[] distribution = new int[k+1];
        for(int i = 1; i <= k; i++) {
            distribution[i] = 1;
        }


        res = 1 << 28;
        dfs(n - k, distribution, 1);

        return res;
    }

    static void dfs(int num, int[] distribution, int start) {
        if(num == 0) {
            check(distribution);
            return;
        }

        for(int i = start; i <= k; i++) {
            if(maximum[i] > distribution[i]) {
                distribution[i]++;
                dfs(num-1, distribution, (maximum[i] == distribution[i]) ? i + 1 : i);
                distribution[i]--;
            }
        }
    }

    static void check(int[] distribution) {
        int[] wait = new int[k+1];
        ArrayList<PriorityQueue<Integer>> arr = new ArrayList<>(k+1);
        for(int i = 0; i <= k; i++) {
            arr.add(new PriorityQueue<>());
        }

        for(int[] i : reqs) {
            if(memo[i[2]][distribution[i[2]]] != null) {
                wait[i[2]] = memo[i[2]][distribution[i[2]]];
                continue;
            }
            PriorityQueue<Integer> tmp = arr.get(i[2]);
            if(distribution[i[2]] > tmp.size()) {
                tmp.add(i[0] + i[1]);
            } else {
                int end = tmp.remove();
                wait[i[2]] += (end >= i[0]) ? end - i[0] : 0;
                tmp.add(Math.max(end, i[0]) + i[1]);
            }
        }
        
        int sum = 0;
        for(int i = 1; i <= k; i++) {
            sum += wait[i];
            if(memo[i][distribution[i]] != null) continue;
            memo[i][distribution[i]] = wait[i];
        }
        res = Math.min(res, sum);
    }
}