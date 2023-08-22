#include <bits/stdc++.h>
using namespace std;

int N, K, ans = -2100000000;
int a[500001], energe[500001], mn;

int main(void) {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> N >> K;
	for (int i = 0; i < N; i++)
		cin >> a[i];
	//순방향
	for (int i = 0; i < N; i++) {
		energe[i] = a[i] - K * i;
	}
	mn = energe[0];
	for (int i = 1; i < N; i++) {
		ans = max(energe[i] - mn, ans);
		mn = min(mn, energe[i]);
	}
	//역방향
	for (int i = 0; i < N; i++) {
		energe[i] = a[N-i-1] - K * i;
	}
	mn = energe[0];
	for (int i = 1; i < N; i++) {
		ans = max(energe[i] - mn, ans);
		mn = min(mn, energe[i]);
	}
	cout << ans;
	return 0;
}