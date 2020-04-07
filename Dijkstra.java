import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;

public class Dijkstra {
	
	static Scanner input = new Scanner(System.in);
	static int l, n;
	static ArrayList<Integer> node1 = new ArrayList<Integer>();
	static ArrayList<Integer> node2 = new ArrayList<Integer>();
	static ArrayList<Integer> length = new ArrayList<Integer>();
	static Hashtable<Integer,Integer> path = new Hashtable<Integer,Integer>();
	static ArrayList<Integer> visited = new ArrayList<Integer>();
	static ArrayList<Integer> weight = new ArrayList<Integer>();
	static ArrayList<Integer> weight_f = new ArrayList<Integer>();
	
	public static void main(String[] args)
	{
		getInput();
		System.out.println("Enter Start node:\t");
		findShortestPath(input.nextInt());
		System.out.println("Enter Ending node:\t");
		int end = input.nextInt();
		System.out.print(end);
		printShortestPath(end);
		input.close();
	}//main()
	
	static void getInput()
	{
		System.out.println("Enter number of Nodes:\t");
		n = input.nextInt();
		System.out.println("Enter number of Edges:\t");
		l = input.nextInt();
		System.out.println("Fill Table of Edges in following pattern:\nNode1 (press Enter)\tNode2 (press Enter)\tLength (press Enter)\n");
		int i = 0;
		while(i<l)
		{
			node1.add(input.nextInt());
			node2.add(input.nextInt());
			length.add(input.nextInt());
			i++;
		}//while
	}//getInput()
	

	
	static void findShortestPath(int s)
	{
		int i=1;
		while(i<=n)
		{
			if(i == s)
			{
				path.put(i, 0);
				weight.add(0);
				
			}
			else
			{
				path.put(i, 0);
				weight.add(1000000);
			}
			i++;
		}//while
	
		
	
		i=0;
		while(i<n)
		{
			Object min = Collections.min(weight);
			int cn = weight.indexOf(min);
			int j=0;
			while(j<l) 
			{
				if(node1.get(j) == cn+1 & weight.get(cn)+length.get(j)<weight.get(node2.get(j)-1) & visited.contains(node2.get(j)) == false)
				{
					path.put(node2.get(j), cn+1);
					weight.set(node2.get(j)-1, weight.get(cn)+length.get(j));
				}
				j++;
			}
			
			j=0;
			while(j<l) 
			{
				if(node2.get(j) == cn+1 & weight.get(cn)+length.get(j)<weight.get(node1.get(j)-1) & visited.contains(node1.get(j)) == false)
				{
					path.put(node1.get(j), cn+1);
					weight.set(node1.get(j)-1, weight.get(cn)+length.get(j));
				}
				j++;
			}
			visited.add(cn+1);
			weight_f.add(weight.get(cn));
			weight.set(cn, 100000000);
			i++;
		}//while
	}//findShortestPath()
	
	static void printShortestPath(int e)
	{
		
		if(path.get(e) == 0)
			{
				return;
			}//if
		System.out.print("<=="+path.get(e));
		printShortestPath(path.get(e));
		
	}//printShortestPath()
}//Dijkstra
