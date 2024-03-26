#include <stdio.h>

int main(){
   int a,b;
   scanf("%d %d",&a,&b);
   
   if(b-45<0){
   	if(a==0) a=23;
   	else a=a-1;
   	b=b+60;
   }
	printf("%d %d",a,b-45);
    
   return 0;
	}
    