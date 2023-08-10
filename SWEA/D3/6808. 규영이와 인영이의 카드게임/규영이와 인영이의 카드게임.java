/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static int[] kyu=new int[9];
	public static int[] inn=new int[9];
	public static int[] inn_select;
	public static boolean[] visited;
	public static int kyu_win;
	public static int kyu_lose;
	public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			boolean[] selected=new boolean[19]; //18장 카드중 규영에게 선택됬는지 체크하는 배열
		inn_select=new int[9];
		visited=new boolean[9];
		kyu_lose=0;
		kyu_win=0;
		
		for(int i=0;i<9;i++) {
			kyu[i]=sc.nextInt();
			selected[kyu[i]]=true;
		}
		
		int idx=0;
		for(int i=1;i<=18;i++) {
			if(!selected[i]) inn[idx++]=i;
		}
		
		do {
			fight();
		} while (np(inn));
		System.out.println("#"+test_case+" "+kyu_win+" "+kyu_lose);
		

		}
	}
    private static boolean np(int[] p) {	// p : 다음 순열을 원하는 기존 순열의 배열
		//1. 맨뒤쪽부터 탐색하며 꼭대기 찾기
		int N=p.length;
		int i=N-1;
		while(i>0&&p[i-1]>=p[i]) --i;
		
		if(i==0) return false; //다음 순열은 없음(가장 큰 순열의 형태)
		
		//2. 꼭대기 직전(i-1) 위치에 교환할 한단계 큰 수 뒤쪽부터 찾기
		int j=N-1;
		while(p[i-1] >= p[j]) --j;
		
		//3. 꼭대기 직전(i-1) 위치의 수와 한단계 큰 수를 교환하기
		swap(p,i-1,j);
		
		//4. 꼭대기자리부터 맨뒤까지의 수를 오름차순의 형태로 바꿈
		int k=N-1;
		while(i<k) {
			swap(p,i++,k--);
		}
		
		//5. 순열 완성됐음을 알리는 true값 리턴
		return true;
	}
	private static void swap(int[] p,int a, int b) {
		int temp=p[a];
		p[a]=p[b];
		p[b]=temp;
	}
	public static void fight() {
		int kyu_score=0;
		int inn_score=0;
		
		for(int i=0;i<9;i++) {
			if(kyu[i]>inn[i]) kyu_score+=kyu[i]+inn[i];
			else if(kyu[i]<inn[i]) inn_score+=kyu[i]+inn[i];
		}
		if(kyu_score==inn_score) return;
		else if(kyu_score>inn_score) kyu_win++;
		else if(kyu_score<inn_score) kyu_lose++;
	
	}
}