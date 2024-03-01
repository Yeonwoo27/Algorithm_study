#include <iostream>
#include <algorithm>

using namespace std;

int main(){
	int a,b,ans=2500;
	char mat[50][50];
	cin>>a>>b;
	
	for(int i=0;i<a;i++){
		for(int j=0;j<b;j++){
			cin>>mat[i][j];
		}
	}
	
	for(int i=0;i<a-7;i++){
		for(int j=0;j<b-7;j++){
			int num1=0,num2=0;
			for(int k=i;k<i+8;k++){
				for(int l=j;l<j+8;l++){
					if(mat[k][l]=='W'){
						if((k+l)%2==0) num1++;
						else num2++;
					}
					else{
						if((k+l)%2==0) num2++;
						else num1++;
					}
						
				}
			}
			ans=min({ans,num1,num2});
		}
	}
	cout<<ans;
	return 0;
}