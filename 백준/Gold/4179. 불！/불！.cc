#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <queue>
#include <cmath>
using namespace std;

int R, C;
int dir[4] = { -1, 1, 0, 0 };
int dic[4] = { 0, 0, 1, -1 };
vector < vector<bool>> visited;
struct s
{
	int row;
	int col;
	bool who;
	int cnt;
};
void Mage(pair<int, int> Jstart, vector<pair<int, int>> Fstart, int cnt)
{
	queue<s> q;
	q.push({Jstart.first, Jstart.second, 1, cnt});
	for (auto a : Fstart) q.push({ a.first, a.second, 0, 0 });

	while (!q.empty())
	{
		int fr = q.front().row;
		int fc = q.front().col;
		bool fwho = q.front().who;
		int fcnt = q.front().cnt;
		q.pop();

		if (visited[fr][fc] && fwho == 1) continue;
		visited[fr][fc] = true;

		for (int i = 0; i < 4; i++)
		{
			int nr = fr + dir[i];
			int nc = fc + dic[i];
			bool nwho = fwho;

			if (nwho)
			{
				if (nr < 0 || nr >= R)
				{
					cout << fcnt + 1 << '\n';
					return;
				}
				if (nc < 0 || nc >= C) 
				{
					cout << fcnt + 1 << '\n';
					return;
				}
			}

			if (nr < 0 || nr >= R) continue;
			if (nc < 0 || nc >= C) continue;

			if (!visited[nr][nc])
			{
				if (nwho)
					q.push({ nr, nc, nwho, fcnt + 1 });
				else
				{
					q.push({ nr, nc, nwho, 0 });
					visited[nr][nc] = true;
				}

			}
		}
	}
	cout << "IMPOSSIBLE" << '\n';
}
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> R >> C;
	pair<int, int> startJ = { 0, 0 };
	vector<pair<int, int>> startF;
	
	visited.assign(R, vector<bool>(C, 0));
	for (int i = 0; i < R; i++)
	{
		for (int j = 0; j < C; j++)
		{
			char c;
			cin >> c;

			if (c == '#') visited[i][j] = 1;
			else if (c == 'J') startJ = { i, j };
			else if (c == 'F')
			{
				//visited[i][j] = 1;
				startF.push_back({ i, j });
			}
		}
	}
	Mage(startJ, startF, 0);
}