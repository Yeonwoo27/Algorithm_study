import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static int N,X;
	public static int[][] arr;
	
	public static void main(String args[]) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int T;
		T = Integer.parseInt(st.nextToken());

		for (int test_case = 1; test_case <= T; test_case++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			X=Integer.parseInt(st.nextToken());
			
			arr=new int[N+1][N+1];
			
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j]=Integer.parseInt(st.nextToken());
				}
				
			}
			
			int ans=0;
			
			for(int i=0;i<N;i++) { //가로 먼저 체크
				boolean isRunwayMade=false;
				int index=0;
				int height=arr[i][index];
				while(true) {
					if(arr[i][index]!=height) break; //이전 높이 값이랑 달라졌으면 break
					if(index==N-1) { //도착했다는 뜻이므로
						isRunwayMade=true;
						break;
					}
					if((index+X)>=N) { //X칸 뒤가 범위를 벗어난다면
						index++;
						continue; 
					}
						
					if((height-1)==arr[i][index+X]) { //X칸 앞의 높이가 현재 인덱스 높이보다 1 낮다면
						boolean possible=true; //경사로 설치 가능여부
						for(int j=1;j<X;j++) {
							if(arr[i][index+j]!=arr[i][index+X]) { //그 사이의 칸들이 조건을 만족하는지 체크
								possible=false;
								break;
							}
						}
						
						if(possible) { //경사로 설치가 가능할 경우
							index=index+X;
							height=height-1; //아래로 가는 경사로이므로 높이 -1
							if(arr[i][index]==arr[i][index+1]) {
								index++;
							}
							continue;
						}
					}
					else if((height+1)==arr[i][index+X]) { //2칸 앞의 높이가 현재 인덱스 높이보다 1 높다면
						boolean possible=true; //경사로 설치 가능여부
						for(int j=1;j<X;j++) {
							if(arr[i][index+j]!=arr[i][index]) { //그 사이의 칸들이 조건을 만족하는지 체크
								possible=false;
								break;
							}
						}
						
						if(possible) { //경사로 설치가 가능할 경우
							index=index+X;
							height=height+1; //위로 가는 경사로이므로 높이 +1
							continue;
						}
					}
					index++;
				}
				
				if(isRunwayMade) {
					ans++;
				}
			}
			
			for(int i=0;i<N;i++) { // 세로 체크
				boolean isRunwayMade=false;
				int index=0;
				int height=arr[index][i];
				while(true) {
					if(arr[index][i]!=height) break; //이전 높이 값이랑 달라졌으면 break
					if(index>=N-1) { //도착했다는 뜻이므로
						isRunwayMade=true;
						break;
					}
					
					if((index+X)>=N) { //X칸 뒤가 범위를 벗어난다면
						index++;
						continue; 
					}
						
					if((height-1)==arr[index+X][i]) { //K칸 앞의 높이가 현재 인덱스 높이보다 1 낮다면
						boolean possible=true; //경사로 설치 가능여부
						for(int j=1;j<X;j++) {
							if(arr[index+j][i]!=arr[index+X][i]) { //그 사이의 칸들이 조건을 만족하는지 체크
								possible=false;
								break;
							}
						}
						
						if(possible) { //경사로 설치가 가능할 경우
							index=index+X;
							height=height-1; //아래로 가는 경사로이므로 높이 -1
							if(arr[index][i]==arr[index+1][i]) {
								index++;
							}
							continue;
						}
					}
					else if((height+1)==arr[index+X][i]) { //2칸 앞의 높이가 현재 인덱스 높이보다 1 높다면
						boolean possible=true; //경사로 설치 가능여부
						for(int j=1;j<X;j++) {
							if(arr[index+j][i]!=arr[index][i]) { //그 사이의 칸들이 조건을 만족하는지 체크
								possible=false;
								break;
							}
						}
						
						if(possible) { //경사로 설치가 가능할 경우
							index=index+X;
							height=height+1; //위로 가는 경사로이므로 높이 +1
							continue;
						}
					}
					index++;
				}
				if(isRunwayMade) {
					ans++;
				}
			}
			
			System.out.println("#"+test_case+" "+ans);
			
		}
	}
	
	

}