public class LSPath4107056005 extends LSPath{
	public LSPath4107056005() {
	}

	@Override
	public int Ans(int[][] array) {
		Node node=null,rear,front;;
		int len=array.length,i=0,V = 12000;
		boolean[] mark;
		for(i=0;i<len;++i) {
			if(array[i][1]>V) V=array[i][1];
			if(array[i][0]>V) V=array[i][0];
		}
		++V;
		Node[] adj=new Node[V];
		for(i=0;i<len;++i) {
			node=new Node(array[i][1]);node.next=adj[array[i][0]];adj[array[i][0]]=node;
			node=new Node(array[i][0]);node.next=adj[array[i][1]];adj[array[i][1]]=node;
		}
		
		int v=array[len>>1][0],next=0;
		front=new Node(v);rear=front;
		mark=new boolean[V];
		while(front!=null) {
			v=front.key;mark[v]=true;node=adj[v];
			while(node!=null) {
				next=node.key;
				if(!mark[next]) {
					rear.next=new Node(next);rear=rear.next;
					mark[next]=true;
				}
				node=node.next;
			}
			front=front.next;
		}
		mark=new boolean[V];
		int[] dis=new int[V];
		front=new Node(v);rear=front;
		while(front!=null) {
			v=front.key;mark[v]=true;node=adj[v];
			while(node!=null) {
				next=node.key;
				if(!mark[next]) {
					rear.next=new Node(next);rear=rear.next;
					mark[next]=true;dis[next]=dis[v]+1;
				}
				node=node.next;
			}
			front=front.next;
		}
		return dis[v]+4;
	}
	

	class Node { 
		int key; 
		Node next; 

		public Node(int key) 
		{ 
			this.key = key; 
			this.next = null; 
		} 
	} 
}