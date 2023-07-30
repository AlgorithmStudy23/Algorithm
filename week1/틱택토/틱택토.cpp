#include <iostream>
#include <math.h>
#include <vector>
using namespace std;

bool tictactoe(string str)
{
	int cnt = 0;
	int cnt_Oline = 0;
	int cnt_Xline = 0;
	// 가로
	for (int i = 0; i < 3; i++)
	{
		if (str[i*3] == str[i*3+1] && str[i*3+1] == str[i*3+2])
		{
			if (str[i * 3] != '.')
			{
				if (str[i * 3] == 'O') cnt_Oline++;
				else cnt_Xline++;
				cnt++;
			}
			

		}
	}
	// 세로
	for (int i = 0; i < 3; i++)
	{
		if (str[i] == str[i+3] && str[i+3] == str[i+6])
		{
			if (str[i + 3] != '.')
			{
				if (str[i + 3] == 'O') cnt_Oline++;
				else cnt_Xline++;
				cnt++;
			}
		}
	}
	// 대각
	if (str[0] == str[4] && str[4] == str[8])
	{
		if (str[4] != '.')
		{
			if (str[4] == 'O') cnt_Oline++;
			else cnt_Xline++;
			cnt++;
		}
	}
	if (str[2] == str[4] && str[4] == str[6])
	{
		if (str[4] != '.')
		{
			if (str[4] == 'O') cnt_Oline++;
			else cnt_Xline++;
			cnt++;
		}
	}

	// 게임판이 가득 찰때
	int bincan = 0;
	int cnt_O = 0;
	int cnt_X = 0;
	for (int i = 0; i < 9; i++)
	{
		if (str[i] == '.')
		{
			bincan++;
		}
		else if (str[i] == 'O')
			cnt_O++;
		else
			cnt_X++;
	}

	if (cnt_O > cnt_X) return false;

	if (cnt == 0)
	{
		if (bincan == 0) return true;
		else return false;
	}
	else {
		if (cnt_Oline > 0)
		{
			if (cnt_O == cnt_X) return true;
		}
		else if (cnt_Xline > 0)
		{
			if ((cnt_X - cnt_O) == 1) return true;
		}
		else return false;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	vector<string> s;
	string str;
	while (cin >> str) { 
		if (str == "end" && s.size() == 0) return 0;
		if (str == "end") break;
		else s.push_back(str);
	}
	for (string st : s) {
		if (tictactoe(st)) cout << "valid" << "\n";
		else cout << "invalid" << "\n";
	}
	return 0;
}