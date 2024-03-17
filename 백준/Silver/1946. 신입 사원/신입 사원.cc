#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#include <string>
using namespace std;


int main(){
	ios::sync_with_stdio(false);
	cin.tie(0);
	int T;
	cin>>T;
	for(int t=0;t<T;t++){
		int N;
		cin>>N;
		vector<int> v(N+1);
		
		for(int i=0;i<N;i++){
			int a,b;
			cin>>a>>b;
			v[a]=b;
		}
		
		int min=v[1];
		int ans=1;
		for(int i=2;i<=N;i++){
			if(min>v[i]){
				ans++;
				min=v[i];
			}
		}
		
		cout<<ans<<endl;
		v.clear();
		
	}
	
	
	return 0;
}