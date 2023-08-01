package week2.베스트_앨범;

import java.util.HashMap;
import java.util.ArrayList;

public class 이동휘_베스트_앨범 {


    class Node implements Comparable<Node> {
        String g;
        int total;
        ArrayList<int[]> idx;

        public Node(String g) {
            this.idx = new ArrayList<>(101);
            this.total = 0;
            this.g = g;
        }

        public void add(int num) {
            total += num;
        }

        @Override
        public int compareTo(Node o) {
            return o.total - total;
        }
    }

    public int[] solution(String[] genres, int[] plays) {

        int len = genres.length;
        HashMap<String, Integer> index = new HashMap<>(100 * 4);
        ArrayList<Node> total = new ArrayList<>(100);
        int x = 0;
        for(String s : genres) {
            if(!index.containsKey(s)) {
                index.put(s, index.size());
                total.add(new Node(s));
            }
            Node tmp = total.get(index.get(s));
            tmp.add(plays[x]);
            tmp.idx.add(new int[]{plays[x], x++});
        }
        total.sort(Node::compareTo);

        len = total.size();
        ArrayList<Integer> arr = new ArrayList<>(len);
        for(int i = 0; i < len; i++) {
            ArrayList<int[]> cur = total.get(i).idx;
            cur.sort((o1, o2) -> o2[0] - o1[0]);
            for(int j = 0; j < Math.min(cur.size(), 2); j++) {
                arr.add(cur.get(j)[1]);
            }
        }

        int[] ans = new int[arr.size()];
        int idx = 0;
        for(int i : arr) {
            ans[idx++] = i;
        }
        return ans;
    }
}
