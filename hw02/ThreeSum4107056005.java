
public class ThreeSum4107056005 extends ThreeSum{

	public ThreeSum4107056005() {
	}

	@Override
	public int T_sum(int[] A) {
		int c=0,h,r,tar,end=A.length-2;
		mSort(A,A.length);
		for(int i=0;i<end;++i) {
			h=i+1; r=end+1; tar=-A[i];
			while(h<r) {
				if(A[h]+A[r]==tar) { ++c;++h;--r;}
				else if(A[h]+A[r]<tar) ++h;
				else --r;
			}
		}
		return c;
	}
	
	private void mSort(int[] A,int n) {
		if(n<=1) return;
		int ln=n/2,rn=n-ln;
		int[] left=new int[ln];int[] right=new int[rn];
		for(int i=0; i<ln; i++) left[i]=A[i];
		for(int i=0; i<rn; i++) right[i]=A[ln+i];	
		mSort(left,left.length);mSort(right,right.length);merge(A,left,right,left.length,right.length);
	    return;
	}
	
	public void merge(int[] A, int[] left, int[] right,int l,int r){
		int i=0, j=0, k=0;
	    while(i<l && j<r){
	        if(left[i]<right[j]){A[k] = left[i]; i++;}
	        else{A[k] = right[j]; j++;}
	        k++;
	    }
	    while(i<l){A[k] = left[i]; i++; k++;}
	    while(j<r){A[k] = right[j];j++; k++;}
	    return;
	}
	
//	private void mSort(int[] A) {
//		int n=A.length;
//		if(n<=1) return;
//		int ln=n/2,rn=n-ln;
//		int[] left=new int[ln];int[] right=new int[rn];
//		for(int i=0; i<ln; i++) left[i]=A[i];
//		for(int i=0; i<rn; i++) right[i]=A[ln+i];	
//		mSort(left);mSort(right);merge(A,left,right);
//	    return;
//	}
//	
//	public void merge(int[] A, int[] left, int[] right){
//		int i=0, j=0, k=0, l=left.length, r=right.length;
//	    while(i<l && j<r){
//	        if(left[i]<right[j]){A[k] = left[i]; i++;}
//	        else{A[k] = right[j]; j++;}
//	        k++;
//	    }
//	    while(i<l){A[k] = left[i]; i++; k++;}
//	    while(j<r){A[k] = right[j];j++; k++;}
//	    return;
//	}
	
//	private void qSort(int[] A, int head, int tail) {
//		if (head >= tail) return;
//		int i = head, j = tail, pivot = A[(head + tail) / 2],t;
//        while (i <= j) {
//            while (A[i] < pivot) ++i;
//            while (A[j] > pivot) --j;
//            if (i < j) {
//                t = A[i]; A[i] = A[j]; A[j] = t; ++i; --j;
//            } else if (i == j) ++i;
//        }
//        qSort(A, head, j);
//        qSort(A, i, tail);
//    }
}
