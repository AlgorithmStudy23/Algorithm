#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

struct Song
{
	int index;
	int play;
	Song(int idx, int p) : index(idx), play(p) {}
};

bool cmp(Song a, Song b)
{
	if (a.play == b.play)
		return a.index < b.index;
	return a.play > b.play;
}

bool cmp2(pair<string, int> a, pair<string, int> b)
{
	return a.second > b.second;
}

vector<int> solution(vector<string> genres, vector<int> plays) {
	vector<int> answer;
	unordered_map<string, int> sum;

	// 키(장르)-값(노래 인덱스, 노래 재생횟수)
	unordered_map<string, vector<Song>> song_hash; 
	for (int i = 0; i < genres.size(); i++)
	{
		sum[genres[i]] += plays[i];
		song_hash[genres[i]].emplace_back(i, plays[i]);
	}

	// 장르 총 재생 수 내림차순 정렬
	vector<pair<string, int>> vec(sum.begin(), sum.end());
	sort(vec.begin(), vec.end(), cmp2);
	
	// 장르 내에서 많이 재생된 노래 먼저
	for (int i = 0; i < song_hash.size(); i++)
	{
		vector<Song> songs = song_hash[vec[i].first];
		sort(songs.begin(), songs.end(), cmp);
        
        //2곡씩, 속한 곡이 1개라면 1개만
		for (int j = 0; j < songs.size(); j++)
		{
            if(j == 2) break;
			answer.push_back(songs[j].index);
		}
	}
	return answer;
}
