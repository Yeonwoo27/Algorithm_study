#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;
using ll=long long;
int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(0), cout.tie(0);
	vector <ll> v;
	vector <ll> ans;
	ll n,a,b,i;
	cin>>n;
	for(ll i=1;i<=200000;i++){
		v.push_back(i*i);
	}
	a=0,b=0;
	while(1){
		if(b>v.size()) break;
		ll dif=v[b]-v[a];
		if(dif<n) b++;
		if(dif>n) a++;
		if(dif==n) {
			ans.push_back(sqrt(v[b]));
			b++;
		}
	}
    if(!ans.size()) cout<<"-1";
	for(int i=0;i<ans.size();i++){
		cout<<ans[i]<<'\n';
	}
	
	
	return 0;
	
}