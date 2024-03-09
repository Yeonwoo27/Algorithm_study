#include <iostream>
#include <queue>
using namespace std;

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	int arr[3]={0,};
	int a,b,n,temp;
	arr[0]=1;
	
	cin>>n;
	
	for(int i=0;i<n;i++){
		cin>>a>>b;
		temp=arr[a-1];
		arr[a-1]=arr[b-1];
		arr[b-1]=temp;
	}
	for(int i=0;i<3;i++){
		if(arr[i]){
			cout<<i+1;
			break;
		}
	}
	return 0;
}