public class PCL4107056005_3 extends PCL{
	public PCL4107056005_3() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkPCL(int[][] array) {
		for(int i=array.length-1; i>-1; --i){
			for(int j=i-1; j>-1; --j){
				for(int k=j-1; k>-1; --k){
					if((array[i][1]-array[j][1])*(array[j][0]-array[k][0])==(array[j][1]-array[k][1])*(array[i][0]-array[j][0])) return true;
				}
			}
		}
		return false;
	}
}
