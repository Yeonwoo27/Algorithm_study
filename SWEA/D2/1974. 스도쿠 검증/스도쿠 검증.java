

import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static int[][] arr;
public static void main(String args[]) throws Exception
{

Scanner sc = new Scanner(System.in);
int T;
T=sc.nextInt();

for(int test_case = 1; test_case <= T; test_case++)
{
	boolean check=true;
	arr=new int[9][9];
	for(int i=0;i<9;i++) {
		for(int j=0;j<9;j++) {
			arr[i][j]=sc.nextInt();
		}
	}
	
	for(int i=0;i<9;i++) {
		int sum1=0;
		int sum2=0;
		for(int j=0;j<9;j++) {
			sum1+=arr[i][j];
			sum2+=arr[j][i];
		}
		if(sum1!=45||sum2!=45) {
			check=false;
			break;
		}
	}
	for(int i=0;i<9;i+=3) {
		for(int j=0;j<9;j+=3) {
			int sum=0;
			for(int k=0;k<3;k++) {
				for(int l=0;l<3;l++) {
					sum+=arr[i+k][j+l];
				}
			}
			if(sum!=45) {
				check=false;
				break;
			}
		}
	}
	for(int i=0;i<9;i++) {
		for(int j=0;j<8;j++) {
			if(arr[i][j]==arr[i][j+1]||arr[j][i]==arr[j+1][i]) {
				check=false;
				break;
			}
		}
	}
	
	System.out.print("#"+test_case+" ");
	if(check) System.out.println("1");
	else System.out.println("0");

}
}
}