#include <iostream>

using namespace std;

int main(){
	int n,num,sum,ans=2000000;
	cin>>n;
	for(int i=0;i<n;i++){
		sum=i;
		num=i;
		while(num!=0){
			sum+=num%10;
			num/=10;
		}
		if(n==sum){
			ans=i;
			break;
		}
	}
    if(ans==2000000) cout<<"0";
	else cout<<ans;
	return 0;
}