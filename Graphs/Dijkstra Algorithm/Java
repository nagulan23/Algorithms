import java.io.*;
import java.util.*;

public class Dijkstra {
	
	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		int n,m,i,u,v,w;
		n=ob.nextInt();
		m=ob.nextInt();
		HashMap<Integer,ArrayList<int[]>> graph=new HashMap<Integer,ArrayList<int[]>>();
		for(i=0;i<m;i++) {
			u=ob.nextInt();
			v=ob.nextInt();
			w=ob.nextInt();
			if(!graph.containsKey(u))
				graph.put(u, new ArrayList<int[]>());
			if(!graph.containsKey(v))
				graph.put(v, new ArrayList<int[]>());
			int v_nextVertex[]=new int[2];
			v_nextVertex[0]=v;
			v_nextVertex[1]=w;
			graph.get(u).add(v_nextVertex);
			int u_nextVertex[]=new int[2];
			u_nextVertex[0]=u;
			u_nextVertex[1]=w;
			graph.get(v).add(u_nextVertex);
		}
		PriorityQueue<int[]> heap=new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] e1,int[] e2) {
				if(e1[1]>e2[1])
					return(1);
				else if(e1[1]<e2[1])
					return(-1);
				else
					return(0);
			}
		});
		int pathWeight[]=new int[n];
		Arrays.fill(pathWeight, Integer.MAX_VALUE);
		int visited[]=new int[n];
		visited[0]=1;
		int takenVertex=0;
		pathWeight[takenVertex]=0;
		int noOfVisited=1;
		while(noOfVisited<n) {
			for(int des[]:graph.get(takenVertex)) {
				if(visited[des[0]]==0) {
					if(pathWeight[takenVertex]+des[1]<pathWeight[des[0]]) {
						pathWeight[des[0]]=pathWeight[takenVertex]+des[1];
						int newDes[]=des.clone();
						newDes[1]=pathWeight[des[0]];
						heap.add(newDes);
					}
				}
			}
			while(visited[heap.peek()[0]]==1)
				heap.remove();
			takenVertex=heap.remove()[0];
			visited[takenVertex]=1;
			noOfVisited++;
		}
		for(i=0;i<n;i++)
			System.out.println("Weight of shortest path between 0 and "+i+" is "+pathWeight[i]);
	}
}
