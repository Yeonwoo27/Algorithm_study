#include <iostream>
#include <stack>
#include <string>

using namespace std;

string s;
double num[30];
int main(){
	cout<<fixed;
	cout.precision(2);
	int a;
	cin>>a;
	cin>>s;
	for(int i=0;i<a;i++) cin>>num[i];
	
	stack<double> d;
	
	for(int i=0;i<s.size();i++){
		if(s[i]=='*'||s[i]=='/'||s[i]=='+'||s[i]=='-'){
			double n=d.top();
			d.pop();
			double m=d.top();
			d.pop();
			if(s[i]=='*')
				d.push(n*m*(1.0));
			else if(s[i]=='/')
				d.push(m/n*(1.0));
			else if(s[i]=='+')
				d.push(n+m);
			else if(s[i]=='-')
				d.push(m-n);
			}
		else
			d.push(num[s[i]-'A']);
		}
	cout<<d.top();
	}
	
