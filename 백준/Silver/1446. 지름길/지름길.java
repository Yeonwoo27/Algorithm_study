import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int D;
    static int dist[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        List<Road> list = new ArrayList<>();
        dist = new int[100001];
        Arrays.fill(dist,100001);

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(D<end) continue;
            if(end-start<=cost) continue;
            list.add(new Road(start, end, cost));
        }

        Collections.sort(list, new Comparator<Road>() {
            @Override
            public int compare(Road o1, Road o2) {
                if(o1.start == o2.start) return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

        int index=0;
        int move =0;

        dist[0] = 0;

        while(move<D){
            if(index<list.size()){
                Road r =list.get(index);
                if(move == r.start){
                    dist[r.end] = Math.min(dist[r.start] + r.cost,dist[r.end]);
                    index++;
                }
                else{
                    dist[move+1]  = Math.min(dist[move]+1,dist[move+1]);
                    move++;
                }
            }else{
                dist[move+1]  = Math.min(dist[move]+1,dist[move+1]);
                    move++;
            }

        }

        System.out.println(dist[D]);
    }
    static class Road{
        int start;
        int end;
        int cost;

        public Road(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
 
}