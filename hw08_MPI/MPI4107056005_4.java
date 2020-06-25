public class MPI4107056005_4 extends MPI{
	public MPI4107056005_4() {}
	@Override
	public int min(int[] array) {
		int len=array.length,i=0;
		boolean[] mark=new boolean[len+1];
		for(;i<len;++i) { if(0<array[i] && array[i]<=len) mark[array[i]]=true;}
		for(i=1;i<=len;++i) {
			if(mark[i]) continue; 
			return i;
		}
		return len+1;
	}

}
