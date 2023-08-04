#include <iostream>

using namespace std;
bool check1[40];	//세로 
bool check2[40];	// /대각 
bool check3[50];	// \대각 
int N,ans=0;
void go(int index){
	if(index==N){
		ans++;
		return;
	}
	for(int i=0;i<N;i++){
		if(check1[i]||check2[i+index]||check3[index-i+N-1]) continue;
		check1[i]= true;
		check2[i+index]=true;	
		check3[index-i+N-1]=true;
		go(index+1);
		check1[i]= false;
		check2[i+index]= false;	
		check3[index-i+N-1]= false;
	}
	
}
int main(){

	cin>>N;

	go(0);
	cout<<ans;
	return 0;
	
}