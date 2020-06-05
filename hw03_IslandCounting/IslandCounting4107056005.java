public class IslandCounting4107056005 extends IslandCounting{
	int islandNum,nodeNum,len,Aroot,Broot;
	ImplementHashMap map;
	int[] id,size;
	public IslandCounting4107056005() {
	}
	@Override
	public int count(String[] A, String[] B) {
		islandNum=0;nodeNum=0;len=A.length;id=new int[len];size=new int[len];
		ImplementHashMap map=new ImplementHashMap(2*len);
		for(int i=0;i<len;++i) {
			Aroot=map.get(A[i]);Broot=map.get(B[i]);
			if(Aroot>-1) {Aroot=find(Aroot);
				if(Broot>-1) {Broot=find(Broot);//AYBY
					if(Aroot!=Broot) {
						if (size[Aroot] < size[Broot]) id[Aroot] = Broot; 
				        else{id[Broot] = Aroot;if(size[Aroot] == size[Broot]) ++size[Aroot];}
						--islandNum;
					}continue;
				}//AYBN
				id[nodeNum]=Aroot;map.put(B[i], nodeNum++);continue;
			}//ANBN
			if(Broot<0) {
				map.put(A[i], nodeNum++);id[nodeNum-1]=nodeNum;id[nodeNum]=nodeNum;++size[nodeNum];
				map.put(B[i], nodeNum++);++islandNum;continue;}
			//ANBY
			id[nodeNum] = find(Broot);map.put(A[i], nodeNum++);
		}
		return islandNum;
	}
	
	public int find(int i) {
		while(id[i]!=i) {
			if(id[id[i]]==id[i]) return id[i];
			id[i]=id[id[i]];i=id[i];}
		return i;
	}
	
	public class ImplementHashMap {
		int index,n,hash;Node[] table;Node node;
		public ImplementHashMap(int n) {
			this.n=getNum(n);
			this.table=new Node[this.n+1];
		}
		class Node{
			 String key;int val,hash;Node next=null;
			 public Node(String key, int val){
				 this.key = key;this.val = val; this.hash=key.hashCode();
			 }
		}
		public void put(String key,int val) {
			node = new Node(key,val);
			index = node.hash&n;
			node.next = table[index];table[index] = node;
		}
		public int get(String key) {
			hash=key.hashCode();
			node = table[hash&n];
			while(node!=null){
				if(node.hash==hash && node.key.equals(key)) return node.val;
				node = node.next;
			}
			return -1;
		}
		public int getNum(int a){
			int n = a -1;
			n |= n >>> 1;
			n |= n >>> 2;
			n |= n >>> 4;
			n |= n >>> 8;
			n |= n >>> 16;
			return n;
		}
	}
}

