
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 9X9인 스도쿠
 * 0이 들어있는 칸에 1~9를 하나씩 넣어본다. 먼저 가로, 세로, 3x3칸에 숫자가 있는지 확인
 * 그렇게 넣어가다가 하나도 넣을수 없는 경우가 생기면 되돌아가기
 */
public class Main {
	public static int[][] arr=new int[9][9];

	public static ArrayList<Node> list=new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		for(int i=0;i<9;i++) {
			String str=sc.nextLine();
			for(int j=0;j<9;j++) {
				arr[i][j]=str.charAt(j)-'0';
				if(arr[i][j]==0) {
					list.add(new Node(i,j));
				}
			}
		}
		

		dfs(0);
		
	}
	public static void dfs( int n) {
		if(n==list.size()) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
			Node current=list.get(n);
			int x=current.x;
			int y=current.y;
			
			if(arr[x][y]!=0) return;
			for(int j=1;j<=9;j++) {
				if(check(x,y,j)) {
					arr[x][y]=j;
					dfs(n+1);
					arr[x][y]=0;
				}
			}
			
		
	}
	public static boolean check(int x, int y, int num) {
		if(!checkColumn(y, num)) return false;
		if(!checkRow(x, num)) return false;
		if(!checkBox(x, y, num)) return false;
		return true;
	}
	public static boolean checkColumn(int y, int num) { //세로에 중복되는 숫자 있는지 체크
		
		for(int i=0;i<9;i++) {
			if(arr[i][y]==num) {
				return false;
			}
		}
		
		return true;
	}
	public static boolean checkRow(int x, int num) { //가로에 중복되는 숫자 있는지 체크
		
		for(int i=0;i<9;i++) {
			if(arr[x][i]==num) {
				return false;
			}
		}
		
		return true;
	}
	public static boolean checkBox(int x, int y, int num) {
		
		int cx=(x/3)*3; //0~2는 0, 3~5는 3, 6~8은 6이 나온다. 
		int cy=(y/3)*3;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(arr[i+cx][j+cy]==num) {
					return false;
				}
			}
		}
		
		return true;
	}
	public static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
	}
}
