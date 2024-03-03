#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;
using ll=long long;
int main(){
	ios_base::sync_with_stdio(0);
	cin.tie(0), cout.tie(0);
	vector <int> v;

	int n,a,sum,ans=0;
 
	cin>>n;
	for(int i=0;i<n;i++){
		cin>>a;
		v.push_back(a);
	}
	sort(v.begin(),v.end());

	for(int i=0;i<n;i++){
		int left=0,right=n-1;
		while(left<right){
			sum=v[left]+v[right];
			if(sum>v[i]) right--;
			else if(sum<v[i]) left++;
			else{
				if(left!=i&&right!=i){
					ans++;
					break;
				}
				if(left==i) left++;
				if(right==i) right--;
			}
		}
	}
	
	cout<<ans;

	
	
	return 0;
	
}