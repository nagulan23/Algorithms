import java.util.Arrays;
import java.util.Scanner;

public class Floyd_Warshall {

	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		int n,m,i,j,k,u,v,w,infinity=Integer.MAX_VALUE;
		n=ob.nextInt();
		m=ob.nextInt();
		boolean directed=ob.nextBoolean();
		int[][] graph=new int[n][n];
		for(i=0;i<n;i++)
			Arrays.fill(graph[i],infinity);
		for(i=0;i<m;i++) {
			u=ob.nextInt();
			v=ob.nextInt();
			w=ob.nextInt();
			graph[u][v]=w;
			if(!directed)
				graph[v][u]=w;
		}
		System.out.println("Given graph:");
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				if(i==j)
					graph[i][j]=0;
				if(graph[i][j]==infinity)
					System.out.print("∞\t");
				else
					System.out.print(graph[i][j]+"\t");
			}
			System.out.println();
		}
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				if(i!=j) {
					for(k=0;k<n;k++) {
						if(k!=i) {
							if(graph[j][i]==infinity || graph[i][k]==infinity)
								continue;
							graph[j][k]=Math.min(graph[j][k],graph[j][i]+graph[i][k]);
						}
					}
				}
			}
		}
		System.out.println("\nShortest path between any two vertices:");
		for(i=0;i<n;i++) {
			for(j=0;j<n;j++) {
				if(graph[i][j]==infinity)
					System.out.print("∞\t");
				else
					System.out.print(graph[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
