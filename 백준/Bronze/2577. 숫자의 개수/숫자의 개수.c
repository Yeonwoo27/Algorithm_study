#include <stdio.h>

int main(){
	int a,b,c,result;
	int x=1;
	int d[10]={0, },k[3];
	for(int i=0;i<3;i++){
		scanf("%d",&k[i]);
	}
	result=k[0]*k[1]*k[2];
	d[result%10]+=1;
	for(int i=1;i<10;i++){
		int num;
		x*=10;
		num=(result/x)%10;
		if((result/x)==0) break;
		d[num]++;
	}
	for(int i=0;i<10;i++){
		printf("%d\n",d[i]);
	}
	return 0;
}