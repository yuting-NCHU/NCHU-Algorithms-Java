public class PCL4107056005 extends PCL{
	boolean flag;int x;
	public PCL4107056005() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkPCL(int[][] array) {
		myHash hash;
		for(int i=array.length-1;i>-1;--i) {
			hash=new myHash(2*i);
			flag=false;
			for(int j=i-1;j>-1;--j) {
				x=(array[i][0]-array[j][0]);
				if(x==0) {
					if(flag==false) flag=true;
					else return true;
				}else {
					if(hash.put((double)(array[i][1]-array[j][1])/x)) return true;
				}
			}
		}
		return false;
	}
	public class myHash{
		int n;Node[] table;
		public myHash(int n) {
			this.n=getN(n);
			table=new Node[this.n+1];
		}
		boolean put(Double val) {
			int index=val.hashCode()&n;
			Node temp=table[index];
			while(temp!=null) {
				if(temp.val==val) return true;
				temp=temp.next;
			}
			Node node=new Node(val);
			node.next=table[index];table[index]=node;
			return false;
		}
	}
	public class Node{
		double val;Node next=null;
		public Node(double val){
			this.val=val;
		}
	}
	int getN(int n) {
		int a=n-1;
        a |= a >>> 1;
        a |= a >>> 2;
        a |= a >>> 4;
        a |= a >>> 8;
        a |= a >>> 16;
		return a;
	}
	
}