#include <stdio.h>
#include <string.h>
int check(char s[]){
	int che=0,ptr=0;
	for(int i=0;i<strlen(s);i++){
		if(s[i]=='('){
			che++;
		}
		else if(s[i]==')'){
			if(che>0) che--;
			else return 0;
		}
		
	}
	if(che==0) return 1;
	else return 0;
}
int main(){
	int t,ptr;
	char stack[50];
	scanf("%d",&t);
	for(int i=0;i<t;i++){
		scanf("%s",stack);
		if(check(stack)==1) printf("YES\n");
		else printf("NO\n");
	}
		return 0;
}