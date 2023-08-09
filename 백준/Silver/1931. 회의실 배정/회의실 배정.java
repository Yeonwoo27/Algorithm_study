
import java.util.*;

public class Main{
	static int N;
	
	static ArrayList<Node> list=new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();	
		
		for(int i=0;i<N;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			list.add(new Node(a,b));
		}
		Collections.sort(list,new Comparator<Node>() {
		
			public int compare(Node o1, Node o2) {
				
				if(o1.y==o2.y) {
					return o1.x-o2.x;
					}
				return o1.y-o2.y;
			}
		});
		
		int ans=1;
		int end=list.get(0).y;
		
		for(int i=1;i<N;i++) {
			if(list.get(i).x>=end) {
				end=list.get(i).y;
				ans++;
			}
		}
			
		System.out.println(ans);
	}
	

	public static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
		
		
			
	

}
