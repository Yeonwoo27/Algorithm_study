#include <stdio.h>
#include <string.h>

int main(){
	int a;
	float score[1001];
	scanf("%d",&a);
	for(int i=0;i<a;i++){
		float student,good=0;
		float sum=0,avg;
		scanf("%f",&student);
		for(int j=0;j<student;j++){
			scanf("%f",&score[j]);
			sum+=score[j];
			}
			avg=sum/student;
		for(int k=0;k<student;k++){
			if(score[k]>avg) good++;
		}
		printf("%.3f%%\n",(good/student)*100);
		
		
	}
	
	return 0;
}