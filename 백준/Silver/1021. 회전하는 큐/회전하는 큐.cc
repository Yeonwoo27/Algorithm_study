#include <iostream>
#include <deque>
#include <string>

using namespace std;


int main(){
	int n,m,num,index,ans=0;
	deque <int> dq;
	
	cin>>n>>m;
	
	for(int i=1;i<=n;i++)
		dq.push_back(i);

	
	while(m--){
		cin>>num;
		for(int i=0;i<dq.size();i++){
			if(num==dq[i]){
				index=i;
				break;
			}
		}
		if(index<dq.size()-index){
			while(1){
				if(num==dq.front()){
					dq.pop_front();
					break;
				}
				int a=dq.front();
				dq.pop_front();
				dq.push_back(a);
				ans++;
				
			}
		}
		else{
			while(1){
				if(num==dq.front()){
					dq.pop_front();
					break;
				}
				int a=dq.back();
				dq.pop_back();
				dq.push_front(a);
				ans++;
			}
		}

	}
	cout<<ans<<'\n';
}
	
