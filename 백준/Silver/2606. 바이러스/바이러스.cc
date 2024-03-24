#include <iostream>
#include <queue>
using namespace std;

int N,M,V,ans=0;
int arr[101][101]={0, };

bool visited[101];


void dfs(int num){
	
	visited[num]=true;
	for(int i=1;i<=N;i++){
		if(arr[num][i]==1&&visited[i]==0){
			ans++;
			dfs(i);
		}
	}
		
	}


int main(){
	
	cin>>N>>M;

	for(int i=0;i<M;i++){
		int a,b;
		cin>>a>>b;
		arr[a][b]=1;
		arr[b][a]=1;
	}
	
	dfs(1);

	cout<<ans;
	
	
	return 0;
}