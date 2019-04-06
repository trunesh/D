import java.io.*;
import java.util.*;
class Dijkstra_single
{
	public int minDistance(int dist[],boolean b[])
	{
		int min=Integer.MAX_VALUE,index=-1;
		for(int x=0;x<dist.length;x++)
		{
			if(b[x]==false && dist[x]<=min)
			{
				min=dist[x];
				index=x;
			}
			
			
		}
		return index;
	}
	
	
	public void dijkstra(int graph[][],int src)
	{
		int leng=graph.length;
		int dist[]=new int[leng];
		boolean[] b=new boolean[leng];
		
		for(int i=0;i<leng;i++)
		{
			dist[i]=Integer.MAX_VALUE;
			b[i]=false;
		}
		
		dist[src]=0;
		
		for(int count=0;count<leng;count++)
		{
			int u=minDistance(dist,b);
			b[u]=true;
			for(int x=0;x<leng;x++)
			{
				if(!b[x]&&graph[u][x]!=0 && dist[u]!=Integer.MAX_VALUE && dist[u]+graph[u][x]<dist[x])
				{
					dist[x]=dist[u]+graph[u][x];
				}
				
			}
			printGraph(dist,leng);
			
		}
		
	}
	public static void printGraph(int dist[],int x)
	{
		System.out.println("Distance from source to destination");
		for(int i=0;i<x;i++)
		{
			System.out.println(i + "-----" + dist[i]);
		}
		
	}
	
	public static void main(String args[])
	{
		int graph[][]=new int[][]{{0,4,0,0,7},
								{4,0,1,2,0},
								{0,1,0,6,0},
								{0,2,6,0,0},			
								{7,0,0,0,0}};
	
	Dijkstra_single ob=new Dijkstra_single();
	Scanner sc=new Scanner(System.in);
	System.out.println("0=A   1=B   2=C   3=D   4=E");
	System.out.println("Enter the Source You Want(i.e. amoong 0 to 4):");
	int source=sc.nextInt();
	ob.dijkstra(graph,source);
	}
}
