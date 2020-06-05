### ArrayData4107056005 rank:8
找array的最大值和最小值，沒什麼算法好想，直接O(N)掃過去
```java
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
```
