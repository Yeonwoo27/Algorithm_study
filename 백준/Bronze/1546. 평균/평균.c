#include <stdio.h>

int main(){
	int a;
	
	float result=0,max;
	float d[1001];
	scanf("%d",&a);
	for(int i=0;i<a;i++) {
		scanf("%f",&d[i]);
		if(d[i]>max) max=d[i];
	
	}
	for(int i=0;i<a;i++) result+=(d[i]/max)*100;
	
	printf("%f",result/a);
	
	
	
	
	return 0;
}