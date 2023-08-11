import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list=new ArrayList<>();
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(7);
		
		for(int i=1;i<N;i++) {
			ArrayList<Integer> new_list=new ArrayList<>();
			for(int j=0;j<list.size();j++) {
				int a=list.get(j);
				for(int k=1;k<=9;k+=2) {
                    if(k%2==0||k==5) continue;
					if(check(a*10+k)) new_list.add(a*10+k); 
				}
			}
			list=new_list;
		}
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		
	}
	public static boolean check(int num) {
		for(int i=num;i>0;i/=10) {
			for(int j=2;j*j<=i;j++) {
				if(i%j==0) return false;
			}
		}
		return true;
	}

}
