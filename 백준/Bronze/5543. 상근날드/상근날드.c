#include <stdio.h>

int main(){
	int b[3];
	int d[2];
	int burger=3000;
	int drink=3000;
	for(int i=0;i<3;i++){
		scanf("%d",&b[i]);
		if(b[i]<burger) burger=b[i];
		
		}
		for(int i=0;i<2;i++){
		scanf("%d",&d[i]);
		if(d[i]<drink) drink=d[i];
		
		}
	printf("%d",burger+drink-50);
	
	return 0;
	
}