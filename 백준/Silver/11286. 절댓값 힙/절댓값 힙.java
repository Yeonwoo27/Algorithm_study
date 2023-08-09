

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		PriorityQueue<Integer> pQ=new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(Math.abs(o1)==Math.abs(o2)) {
					if(o1>o2) return 1;
					else return -1;
				}
				return Math.abs(o1)-Math.abs(o2);
			}
			
		});
		
		N=sc.nextInt();
		
		for(int i=0;i<N;i++) {
			int num=sc.nextInt();
			
			if(num==0) {
				if(pQ.size()==0) System.out.println("0");
				else System.out.println(pQ.poll());
			}
			else {
				pQ.add(num);
			}
		}
	}

}
