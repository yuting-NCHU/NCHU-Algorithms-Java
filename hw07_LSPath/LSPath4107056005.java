public class LSPath4107056005 extends LSPath{
	public LSPath4107056005() {
	}

	@Override
	public int Ans(int[][] array) {
		Node node=null,rear,front;;
		int len=array.length,i=0,V = 12000; //不能設太小，不然會一直更動，降低效能
		boolean[] mark;
		//找總共需要多少陣列空間
		for(i=0;i<len;++i) {
			if(array[i][1]>V) V=array[i][1];
			if(array[i][0]>V) V=array[i][0];
		}
		++V;
		Node[] adj=new Node[V];
		//做adjency list
		for(i=0;i<len;++i) {
			node=new Node(array[i][1]);node.next=adj[array[i][0]];adj[array[i][0]]=node;
			node=new Node(array[i][0]);node.next=adj[array[i][1]];adj[array[i][1]]=node;
		}
		//v=start 隨便一個點都行
		int v=array[0][1],next=0;
		front=new Node(v);rear=front;
		mark=new boolean[V];
		while(front!=null) { //第一次BFS
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
		while(front!=null) { //第二次BFS
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
		return dis[v]+4; //因BFS只可能算小不可能算大，所以又加4(誤差範圍)
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
