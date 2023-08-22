#include <string>
#include <vector>
#include <iostream>
#include <cstring>
#include <algorithm>
#include <math.h>
using namespace std;

bool isPrime(int n)
{
    if(n < 2) return false;
    for(int i=2; i<=sqrt(n); i++)
    {
        if(n%i == 0) return false;
    }
    return true;
}

int solution(string numbers) {
    int answer = 0;
    vector<char> v;
    vector<int> num;
    for(int i=0; i<numbers.length(); i++)
    {
        v.push_back(numbers[i]);
    }
    sort(v.begin(), v.end());
    do{
        string str = "";
        for(int i=0; i<v.size(); i++)
        {
            str.push_back(v[i]);
            num.push_back(stoi(str));
        }
    }while(next_permutation(v.begin(), v.end()));
    
    sort(num.begin(), num.end());
    num.erase(unique(num.begin(), num.end()), num.end());
    for(int i=0; i<num.size(); i++)
    {
        if(isPrime(num[i])) answer++;
    }
    return answer;
}