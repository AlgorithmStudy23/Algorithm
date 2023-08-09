package week3.미로_탈출_명령어;

import java.io.*;
public class 이동휘_미로_탈출_명령어 {

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        if(dist(x, y, r, c) % 2 != k % 2 || k < dist(x, y, r, c)) {
            return "impossible";
        }
        String res = "";
        while(x < n && k > dist(x, y, r, c)) {
            k--;
            x++;
            res += 'd';
        }
        while(y > 1 && k > dist(x, y, r, c)) {
            k--;
            y--;
            res += 'l';
        }
        while(k > dist(x, y, r, c)) {
            k -= 2;
            res += 'r';
            res += 'l';
        }
        if(x < r) {
            for(int i = (r - x); i > 0; i--) {
                res += 'd';
            }
        }
        if(y > c) {
            for(int i = (y - c); i > 0; i--) {
                res += 'l';
            }
        }
        if(y < c) {
            for(int i = (c - y); i > 0; i--) {
                res += 'r';
            }
        }
        if(x > r) {
            for(int i = (x - r); i > 0; i--) {
                res += 'u';
            }
        }

        return res;
    }
    static int dist(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }
}