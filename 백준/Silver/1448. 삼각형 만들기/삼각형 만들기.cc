#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(int a, int b){
	return a>b;
}
int main(){
	int n, k=0;
	cin>>n;
	vector <int> v(n);
	
	for(int i=0;i<n;i++) cin>>v[i];
	
	sort(v.begin(), v.end(), compare);
	
	while(1){
		if(v[k]<v[k+1]+v[k+2]) break;
		k++;
		if(k+2==n){
			cout<<"-1";
			return 0;
		}
	}
	cout<<v[k]+v[k+1]+v[k+2]<<endl;
	
	return 0;
}
