

import java.util.Scanner;

public class Main{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		
		for(int i=N/5;i>=0;i--) {
			if((N-i*5)%3==0) {
				System.out.println(i+(N-i*5)/3);
				return;
			}
		}
		System.out.println("-1");
	}

}
