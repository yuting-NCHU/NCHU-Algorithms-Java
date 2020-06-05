
public class ArrayData4107056005 extends ArrayData{
	private int max,min;
	public ArrayData4107056005(int[] A) {
		this.A=A;
		min = A[0];
		max = A[0];
		int a=A.length;
	    for(int i=1; i<a; i++) {
	    	if(A[i]>max) {max=A[i];}
	    	if(A[i]<min) {min=A[i];}
	    }
	        
	}

	@Override
	public int max() {
		return max;
	}

	@Override
	public int min() {
	    return min;
	}

}
