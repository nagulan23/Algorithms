import java.io.*;
import java.util.*;

public class Kahn_topological_sort {

	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		int n,m,i,u,v,vertex;
		n=ob.nextInt();
		m=ob.nextInt();
		HashMap<Integer,ArrayList<Integer>> graph=new HashMap<Integer,ArrayList<Integer>>();
		int inDegree[]=new int[n];
		for(i=0;i<m;i++) {
			u=ob.nextInt();
			v=ob.nextInt();
			if(!graph.containsKey(u))
				graph.put(u, new ArrayList<Integer>());
			graph.get(u).add(v);
			inDegree[v]++;
		}
		ArrayList<Integer> stack=new ArrayList<Integer>();
		ArrayList<Integer> order=new ArrayList<Integer>();
		for(i=0;i<n;i++) {
			if(inDegree[i]==0)
				stack.add(i);
		}
		if(stack.size()==0)
			System.out.println("Topological ordering doesnot exist");
		int visited[]=new int[n];
		while(stack.size()!=0) {
			vertex=stack.remove(stack.size()-1);
			order.add(vertex);
			visited[vertex]=1;
			if(graph.containsKey(vertex))
			for(int j:graph.get(vertex)) {
				if(visited[j]==0) {
					inDegree[j]--;
					if(inDegree[j]==0) {
						stack.add(j);
					}
				}
			}
		}
		if(order.size()!=n)
			System.out.println("Topological ordering doesnot exist");
		else {
			System.out.print("Topological ordering for the graph is ");
			for(int j:order)
				System.out.print(j+" ");
		}
	}
}
