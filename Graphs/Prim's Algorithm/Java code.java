import java.util.*;

public class Prims {

	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		int n,m,i,u,v,temp,w;
		n=ob.nextInt();
		m=ob.nextInt();
		HashMap<Integer,ArrayList<int[]>> neighbour=new HashMap<Integer,ArrayList<int[]>>();
		for(i=0;i<m;i++){
			u=ob.nextInt();
			v=ob.nextInt();
			w=ob.nextInt();
			if(!neighbour.containsKey(u))
				neighbour.put(u,new ArrayList<int[]>());
			if(!neighbour.containsKey(v))
				neighbour.put(v,new ArrayList<int[]>());
			int[] v_vertexWeight=new int[2];
			v_vertexWeight[0]=v;
			v_vertexWeight[1]=w;
			int[] u_vertexWeight=new int[2];
			u_vertexWeight[0]=u;
			u_vertexWeight[1]=w;
			neighbour.get(u).add(v_vertexWeight);
			neighbour.get(v).add(u_vertexWeight);
		}
		PriorityQueue<int[]> heap=new PriorityQueue<int[]>(new Comparator<int[]>() {
			public int compare(int[] e1,int[] e2) {
				if(e1[2]>e2[2])
					return(1);
				else if(e1[2]<e2[2])
					return(-1);
				else
					return(0);
			}
		});
		int visited[]=new int[n];
		visited[0]=1;
		int takenVertex=0;
		int mstSize=0;
		int mstWeight=0;
		System.out.println("-------- Selected Edges");
		while(mstSize<n-1) {
			for(int[] des:neighbour.get(takenVertex)) {
				if(visited[des[0]]==0) {
					int edge[]=new int[3];
					edge[0]=takenVertex;
					edge[1]=des[0];
					edge[2]=des[1];
					heap.add(edge);
				}
			}
			int[] takenEdge=heap.remove();
			while(visited[takenEdge[1]]==1)
				takenEdge=heap.remove();
			System.out.println(Arrays.toString(takenEdge));
			takenVertex=takenEdge[1];
			visited[takenVertex]=1;
			mstWeight+=takenEdge[2];
			mstSize++;
		}
		System.out.println("Weight of MST = "+mstWeight);
	}

}
