
public class slash4107056005 extends slash{
	int lo,hi,mid;
	public slash4107056005() {
	}

	@Override
	public int slash_min(int[] A) {
		lo=0;hi=A.length;mid=hi/2;
		while(A[mid+1]>A[mid]) {
			if(A[mid]<A[0]) hi=mid;
			else lo=mid;
			mid=(lo+hi)/2;
		}
		return A.length-mid-2;
	}
}
