#include <iostream>
#include <string>
#include <stack>

using namespace std;


int main(){
	

	while(1){
		int check=0;
		string s;
		stack <char> d;
		getline(cin, s);
		if(s[0]=='.') break;
		
	for(int i=0;i<s.size();i++){
			if(s[i]=='(')	d.push(s[i]);
			else if(s[i]=='[') d.push(s[i]);
			else if(s[i]==')'){
				if(d.empty()||d.top()!='(') {
					check=1;
					break;
				}
				d.pop();
			}
			else if(s[i]==']'){
				if(d.empty()||d.top()!='['){
					check=1;
					break;
				} 
				d.pop();
			}
			
		}
		if(d.empty()&&!check) printf("yes\n");
		else printf("no\n");
	}
}