
import java.util.*;

import java.io.FileInputStream;

public class Solution {
    public static int M,A;
    public static int[][]map;
    public static int[] aTime;
    public static int[] bTime;
    public static int[] dx= {0,0,1,0,-1};
    public static int[] dy= {0,-1,0,1,0};
    public static boolean[] aSelect;
    public static boolean[] bSelect;
    public static ArrayList<Battery> bcList;
    public static int ans;
    
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            map=new int[11][11]; //10x10 영역의 지도 생성
            bcList=new ArrayList<>();
            M=sc.nextInt();
            A=sc.nextInt();
            aTime=new int[M+1];
            bTime=new int[M+1];
            int aX=1,aY=1,bX=10,bY=10; // 사용자 A,B의 좌표
            ans=0;
            
            
            for(int i=1;i<=M;i++) {
                aTime[i]=sc.nextInt();
            }
            for(int i=1;i<=M;i++) {
                bTime[i]=sc.nextInt();
            }
            for(int i=0;i<A;i++) {
                int x=sc.nextInt();
                int y=sc.nextInt();
                int c=sc.nextInt();
                int p=sc.nextInt();
                bcList.add(new Battery(x, y, c, p));
            }
            
          
            int result=0;
            for(int i=0;i<=M;i++) {
                aX=aX+dx[aTime[i]]; //A의 x좌표 이동
                aY=aY+dy[aTime[i]]; //A의 y좌표 이동
                bX=bX+dx[bTime[i]]; //B의 x좌표 이동
                bY=bY+dy[bTime[i]]; //B의 x좌표 이동
               
                int[][] select=new int[2][A];
                for(int j=0;j<bcList.size();j++) { 
                    Battery b=bcList.get(j);
                    if(Math.abs(aX-b.x)+Math.abs(aY-b.y)<=b.c) {//A좌표에서 각 BC와의 거리를 비교해 범위 내면 select배열에 1 추가
                        select[0][j]+=1;
                    }
          
                    if(Math.abs(bX-b.x)+Math.abs(bY-b.y)<=b.c) {//B좌표에서 각 BC와의 거리를 비교해 범위 내면 select배열에 1 추가
                    	select[1][j]+=1;         
                    }
                }
                int max=0;
                for(int j=0;j<A;j++) { //중복조합
                	for(int k=0;k<A;k++) {
                		int sum=0;
                		if(select[0][j]==1) {
                			if(select[1][k]==1) {
                				if(j==k) { 
                					sum=bcList.get(j).p; //같은 구역을 공유할 때
                				}
                				else {
                					sum=(bcList.get(j).p+bcList.get(k).p); //다른 구역에서 충전할 때
                				}
                			}
                			else {
                				sum=bcList.get(j).p; //A만 충전할 때
                			}
                		}
                		else {
                			if(select[1][k]==1) {
                				sum=bcList.get(k).p; //B만 충전할 때
                			}
                		}
                		
                		max=Math.max(max, sum);
                	}
                }
                ans+=max;
                
            }
            System.out.println("#"+test_case+" "+ans);
        }
    }
    
    public static class Battery implements Comparable<Battery>{
        int x,y,c,p;

        public Battery(int x, int y, int c, int p) {
            super();
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }

        @Override
        public int compareTo(Battery o) {
            // TODO Auto-generated method stub
            return Integer.compare(o.p,this.p);
        }
    }
}
