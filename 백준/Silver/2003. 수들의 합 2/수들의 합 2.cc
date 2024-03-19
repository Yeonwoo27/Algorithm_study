#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int d[1030][1030];
int pre[1030][1030];
int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(0), cout.tie(0);
	vector <int> v;
	int n,m,a,b,sum=0,ans=0;
	cin>>n>>m;
	for(int i=0;i<n;i++){
		cin>>a;
		v.push_back(a);
	}
	a=0,b=0;
	while(1){
		if(sum>=m) sum-=v[a++];
		else if(b==n) break;
		else sum+=v[b++];
		if(sum==m) ans++;
	}
	cout<<ans<<'\n';
	
	return 0;
	
}