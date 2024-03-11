#include <iostream>
#include <algorithm>

using namespace std;
int dp[10001][501][2],arr[10001],a,b;
int main(){
		ios_base::sync_with_stdio(0);
		cin.tie(0), cout.tie(0);
		
		cin>>a>>b;
		for(int i=1;i<=a;i++){
			cin>>arr[i];
		}
		for(int i=1;i<=a;i++){
			for(int j=0;j<=b;j++){
				if(j!=1){
					if(j){
						dp[i][j][1]=dp[i-1][j-1][1]+arr[i];
						dp[i][j][0]=max(dp[i-1][j+1][1],dp[i-1][j+1][0]);
					}
					else dp[i][j][0]=max({dp[i-1][j+1][0],dp[i-1][j+1][1],dp[i-1][j][0]});
				}
				else {
					dp[i][j][1]=max(dp[i-1][j-1][0],dp[i-1][j-1][1])+arr[i];
					dp[i][j][0]=max(dp[i-1][j+1][1],dp[i-1][j+1][0]);
				}
			}
		}
		cout<<dp[a][0][0];
}