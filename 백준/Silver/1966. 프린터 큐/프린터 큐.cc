#include <iostream>
#include <queue>
#include <string>

using namespace std;


int main(){
	int t,n,m,num;
	cin>>t;
	while(t--){
		int ans=0;
		queue <pair<int,int>> q;
		priority_queue <int> qq;
		cin>>n>>m;
		for(int i=0;i<n;i++){
			cin>>num;
			q.push({i,num});
			qq.push(num);
		}
		while(!q.empty()){
			int a=q.front().first;
			int b=q.front().second;
			q.pop();

			if(qq.top()==b){
				qq.pop();
				ans++;
				if(a==m){
					cout<<ans<<'\n';
					break;
				}
			}
			else q.push({a,b});
			
		}
		
	}
	

	}
	
