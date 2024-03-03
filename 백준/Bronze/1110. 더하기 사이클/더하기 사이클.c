#include <stdio.h>

int main(){
	int a,b;
	
	int num=0;
	scanf("%d",&a);
	b=a;
	while(1){
		int result;
		result=((b%10)*10)+(((b/10)+(b%10))%10);
		num++;
		if(result==a) break;
		b=result;
	}
	printf("%d",num);
	
	return 0;
}