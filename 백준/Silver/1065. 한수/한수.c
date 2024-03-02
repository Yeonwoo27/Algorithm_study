#include <stdio.h>

int han(int n){
	int result=0;
	for(int i=1;i<=n;i++){
		int a1,a2,a3;
		if(i<100) result++;
		else{
		a1=i/100;
		a2=(i/10)%10;
		a3=i%10;
		if((a2-a1)==(a3-a2)) result++;}
	}
	return result;
}
	



int main(){
	int t;
	scanf("%d",&t);
	printf("%d",han(t));
	
	return 0;
}