public class IslandCounting4107056005_2 extends IslandCounting{
	int islandNum,len,a,b;
	int[] id,size;
	public IslandCounting4107056005_2() {
	}
	@Override
	public int count(String[] A, String[] B) {
		islandNum=0;len=A.length;id=new int[2*len];size=new int[2*len];
		id[0]=-1;
		for(int i=0;i<len;++i) {
			a=Integer.parseInt(A[i])+1;b=Integer.parseInt(B[i])+1;
			if(id[a]>0) {a=find(a);
				if(id[b]>0) {b=find(b);//AYBY
					if(a!=b) {
						if (size[a] < size[b]) id[a] = b; 
				        else{id[b] = a;if(size[a] == size[b]) ++size[a];} --islandNum;
					}continue;
				}//AYBN
				id[b]=a;continue;
			}//ANBN
			if(id[b]==0) {id[a]=b;id[b]=b;++size[b];++islandNum;continue;}
			//ANBY
			id[a] = find(b);
		}
		return islandNum;
	}
	
	public int find(int i) {
		while(id[i]!=i) {
			id[i]=id[id[i]];i=id[i];}
		return i;
	}
}
