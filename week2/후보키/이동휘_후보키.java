package week2.후보키;

import java.util.Stack;
import java.util.HashSet;

public class 이동휘_후보키 {

    static HashSet<String> set;
    static String[][] relation;
    static int attribute, tuple, res;

    public int solution(String[][] Relation) {
        relation = Relation;
        tuple = relation.length;
        attribute = relation[0].length;
        set = new HashSet<>();

        res = 0;
        for(int i = 1; i <= attribute; i++) {
            dfs(new Stack<>(), 0, i);
        }

        return res;
    }
    static boolean contain(Stack<Integer> list) {
        boolean[] c = new boolean[attribute];
        for(int i : list) {
            c[i] = true;
        }
        for(String s : set) {
            int len = s.length();
            int cnt = 0;
            for(int i = 0; i < len; i++) {
                if(c[s.charAt(i)-'0']) {
                    cnt++;
                }
            }
            if(cnt == len) {
                return true;
            }
        }

        return false;
    }

    static void dfs(Stack<Integer> list, int start, int cnt) {
        if(list.size() == cnt) {
            if(!contain(list) && check(list)) {
                res++;
            }
            return;
        }

        for(int i = start; i < attribute; i++) {
            list.add(i);
            dfs(list, i + 1, cnt);
            list.pop();
        }
    }

    static boolean check(Stack<Integer> list) {
        HashSet<String> con = new HashSet<>();

        for(int i = 0; i < tuple; i++) {
            String s = "";
            for(int j : list) {
                s += relation[i][j];
            }
            if(con.contains(s)) {
                return false;
            }
            con.add(s);
        }
        String s = "";
        for(int i : list) {
            s += String.valueOf(i);
        }
        set.add(s);

        return true;
    }
}
