import java.util.*;

public class Kruskal {
	
	public static void sort(int arr[][], int col) {
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(final int[] entry1,final int[] entry2) {
				if(entry1[col]>entry2[col])
					return(1);
				else
					return(-1);
			}
		});
	}
	
	public static void main(String[] args) {
		Scanner ob=new Scanner(System.in);
		int n,m,u,v,i,temp,weight,noOfEdges=0;
		n=ob.nextInt();
		m=ob.nextInt();
		int edge[][]=new int[m][3];
		for(i=0;i<m;i++){
			u=ob.nextInt();
			v=ob.nextInt();
			weight=ob.nextInt();
			if(v<u) {
				temp=u;
				u=v;
				v=temp;
			}
			edge[i][0]=u;
			edge[i][1]=v;
			edge[i][2]=weight;
		}
		sort(edge,2);
		System.out.println("-------- Sorted Edges");
		for(i=0;i<m;i++)
			System.out.println(Arrays.toString(edge[i]));
		int mst[]=new int[n];
		for(i=0;i<n;i++)
			mst[i]=-1;
		int selectedEdges[]=new int[m];
		int mstWeight=0,uparent,vparent;
		i=0;
		while(noOfEdges<n-1) {
			u=edge[i][0];
			v=edge[i][1];
			weight=edge[i][2];
			vparent=v;
			while(mst[vparent]!=-1) {
				vparent=mst[vparent];
			}
			uparent=u;
			while(mst[uparent]!=-1) {
				uparent=mst[uparent];
			}
			if(vparent!=uparent) {
				mst[vparent]=u;
				noOfEdges++;
				mstWeight+=weight;
				selectedEdges[i]=1;
			}
			i++;
		}
		System.out.println("-------- Selected Edges");
		for(i=0;i<m;i++)
			if(selectedEdges[i]==1)
				System.out.println(Arrays.toString(edge[i]));
		System.out.println("Weight of MST = "+mstWeight);
	}
}
