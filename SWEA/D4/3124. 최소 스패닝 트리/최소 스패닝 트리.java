
import java.util.*;
import java.io.*;

class Solution {
    public static int V, E;
    public static ArrayList<Vertex>[] list; // 인접리스트
    public static int[] arr;

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T;
        T = Integer.parseInt(st.nextToken());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            list=new ArrayList[V+1];
            for(int i=1;i<=V;i++) list[i]=new ArrayList<>();
            
            for(int i=0;i<E;i++) {
                st = new StringTokenizer(br.readLine());
                int from=Integer.parseInt(st.nextToken());
                int to=Integer.parseInt(st.nextToken());
                int weight=Integer.parseInt(st.nextToken());
                
                list[from].add(new Vertex(to,weight));
                list[to].add(new Vertex(from,weight));
            }
            boolean[] visited=new boolean[V+1]; //방문 정점
            int[] minEdge=new int[V+1]; // 자신과 트리의 정점들 간 최소 간선 비용

            for(int i=1;i<=V;i++) minEdge[i]=Integer.MAX_VALUE;
            PriorityQueue<Vertex> pQueue=new PriorityQueue<>();
            minEdge[1]=0; //임의의 1정점을 트리 구성의 시작으로 설정
            pQueue.add(new Vertex(1,0));
            
            long result=0;
            int min = 0, minVertex = 0, cnt = 0;
            
            while(!pQueue.isEmpty()) {
                Vertex cur=pQueue.poll();
                minVertex=cur.no;
                min=cur.weight;
                
                if(visited[minVertex]) continue;
                
                visited[minVertex]=true;
                result+=min;    //간선이 추가됐으므로 result에 가중치를 더한다.
                for(int i=0;i<list[minVertex].size();i++) {
                	if(!visited[list[minVertex].get(i).no]) {
                		pQueue.add(new Vertex(list[minVertex].get(i).no,list[minVertex].get(i).weight));
                	}
                }
            }
            System.out.println("#" + test_case + " " + result);
        }
    }

    public static class Vertex implements Comparable<Vertex> { // Vertex 클래스
        int no, weight;

        public Vertex(int no, int weight) {
            super();
            this.no = no;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex o) { // 가중치로 오름차순 정렬하기 위한 compareTo 함수

            return Integer.compare(this.weight, o.weight);
        }

    }
}