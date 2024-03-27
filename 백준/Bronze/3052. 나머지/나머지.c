#include <stdio.h>

int main(){
	int result=0;
	int d[42]={0, };
	for(int i=0;i<10;i++){
		int a;
		int div;
		scanf("%d",&a);
		div=a%42;
		if(d[div]==0) d[div]+=1;
	}
	for(int i=0;i<42;i++){
		if(d[i]!=0) result++;
	}
	printf("%d",result);
	return 0;
}