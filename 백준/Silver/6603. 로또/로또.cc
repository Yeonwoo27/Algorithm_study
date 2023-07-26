#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;



int main(){
   
	
	while(1){
		
		int n;
		cin>>n;
		if(n==0)
			break;
			vector <int> d(n);
            vector <int> a(n);
	for(int i=0;i<n;i++)
		cin>>a[i];
	for(int i=0;i<6;i++)
		d[i]=1;
	
		do{	
			
		for(int i=0;i<n;i++){
			if(d[i]==1)
				cout<<a[i]<<" " ;
		}
		cout<<'\n';
	}while(prev_permutation(d.begin(),d.end()));
		
cout<<'\n';
		
			}
    return 0;
}