#include <stdio.h>
#include <string.h>
int main(){
	int len,result=0;
   char d[1000001];
   scanf("%[^\n]",d);
   len=strlen(d);
   for(int i=0;i<len;i++){
   	if(d[i]==' '&&i!=0&&i!=len-1) result++;
   }
    if(d[0]==' '&&d[1]==0) printf("0");
  else printf("%d",result+1);
   
   return 0;
}