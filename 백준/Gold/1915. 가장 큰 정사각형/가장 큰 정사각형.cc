#include <iostream>
#include <algorithm>
#include <cstdio>
using namespace std;

int a[1003][1003];
int d[1003][1003];
int ans=0;
int main(){
 	 int n,m;
	cin>>n>>m;
	
	for(int i=1;i<=n;i++){
		for(int j=1;j<=m;j++){
			scanf("%1d",&a[i][j]); //한자리씩 입력할때는(이어서 입력할때는) cin보다는 scanf로 한자리수 정수받는것이 더 편함.
		}
	}
	
	for(int i=1;i<=n;i++){
		for(int j=1;j<=m;j++){
			if(a[i][j]){
				d[i][j]=min(min(d[i-1][j],d[i][j-1]),d[i-1][j-1])+1;
                ans=max(d[i][j],ans);
			}
				
		}
	}
	
	cout<<ans*ans;
	return 0;
}