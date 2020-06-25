public class MPI4107056005 extends MPI {
	public MPI4107056005() {}
	@Override
	public int min(int[] array) {
		int l = 0,temp;
		int r = array.length; 
		while (l < r) {
			if (array[l] == l + 1) {
				l++;
			} else if (array[l] > r || array[l] <= l || array[array[l] - 1] == array[l])
			{
				array[l] = array[--r];

			} else 
			{
				temp = array[l];
				array[l] = array[array[l] - 1];
				array[temp - 1] = temp;

			}
		}
		return l + 1;
	}

}
