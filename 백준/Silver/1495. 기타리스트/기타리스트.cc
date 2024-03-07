#include <iostream>

using namespace std;

int a[101]={0};
int d[101][1001]={0};

int main(){
 	
	int n,s,m;
	cin>>n>>s>>m;
	for(int i=1;i<=n;i++)
		cin>>a[i];
	
	d[0][s]=1;
	for(int i=1;i<=n;i++){
		for(int j=0;j<=m;j++){
			if(d[i-1][j]){
				if(j+a[i]<=m) d[i][j+a[i]]=d[i-1][j];
				if(j-a[i]>=0) d[i][j-a[i]]=d[i-1][j];
			}
		}
	}
	int ans=-1;
	for(int i=0;i<=m;i++){
		if(d[n][i]) ans=i;
	}
	cout<<ans<<endl;
	
	return 0;
}
