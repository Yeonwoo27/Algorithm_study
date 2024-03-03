#include <iostream>
#include <queue>
#include <string>

using namespace std;

queue <int> q;

int main(){
	int n,k,num=0;
	cin>>n>>k;
	for(int i=1;i<=n;i++) q.push(i);
	cout<<"<";
	while(!q.empty()){
		num++;
		int a=q.front();
		q.pop();
		if(num==k){
			if(q.size()==0)
				cout<<a<<">";
			else
				cout<<a<<", ";
			num=0;
		}
		else q.push(a);
	}
	}
	
