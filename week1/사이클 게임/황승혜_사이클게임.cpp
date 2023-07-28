#include<iostream>
#include <vector>
#include <algorithm>
#define MAX 500000

using namespace std;

int n, m;
int parent[MAX];
int find(int n)
{
	if (parent[n] == n) return n;
	else return parent[n] = find(parent[n]);
}

bool isUnion(int x, int y)
{
	x = find(x); // x의 부모노드
	y = find(y); // y의 부모노드

	if (x == y) // x와 y의 부모노드가 같으면 사이클
		return true;
	else
	{
		// 아니라면 노드를 결합
		parent[x] = y;
		return false;
	}
}

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(NULL);
	cout.tie(NULL);
	int result = 0;
	int x, y;
	cin >> n >> m;

	// 초기화
	for (int i = 0; i < n; i++)
	{
		parent[i] = i;
	}

	// 입력
	for (int i = 0; i < m; i++)
	{
		cin >> x >> y;
		if (isUnion(x, y))
		{
			// 사이클이 만들어지면 순서 i 반환
			result = i+1;
			break;
		}
	}
	cout << result << endl;
	return 0;
}