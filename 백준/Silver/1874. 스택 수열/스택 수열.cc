#include <iostream>
#include <stack>
#include <vector>
using namespace std;

int main(){
	int n,a[100001];
	int pos=0;
	stack <int> s;
	vector <char> c;
	cin>>n;
	for(int i=0;i<n;i++) cin>>a[i];
	
	for(int i=1;i<=n;i++){
		s.push(i);
		c.push_back('+');
			while(!s.empty()&&s.top()==a[pos]){
				s.pop();
				c.push_back('-');
				pos++;
			}
	}
	if(!s.empty()) puts("NO");
	else for(int i=0;i<c.size();i++) cout<<c[i]<<'\n';
	
	return 0;
}