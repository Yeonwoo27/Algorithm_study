import java.util.Scanner;

public class Main {

	public static int T;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		T=sc.nextInt();
		
		int A=0,B=0,C=0; // A는 300초, B는 60초, C는 10초
		
		while(true) { //T값에서 최대한 300초를 빼준다
			if(T-300>=0) {
				A++;
				T=T-300;
			}
			else break;
		}
		while(true) { //T값에서 최대한 60초를 빼준다
			if(T-60>=0) {
				B++;
				T=T-60;
			}
			else break;
		}
		while(true) { //T값에서 최대한 10초를 빼준다
			if(T-10>=0) {
				C++;
				T=T-10;
			}
			else break;
		}
		if(T==0) { //T가 0이 되었다는 것은 300초, 60초, 10초의 조합으로 딱 나누어 떨어진것이므로 답 출력
			System.out.println(A+" "+B+" "+C);
		}
		else System.out.println("-1"); //아니라면 -1 출력
	}

}
