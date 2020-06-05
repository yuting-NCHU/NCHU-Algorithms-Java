### ArrayData4107056005 rank:8
找array的最大值和最小值，沒什麼算法，直接O(N)掃過去
```java
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
}
```
### 與線程魔法使的比較 rank:5
```java
public class ArrayData4107056019 extends ArrayData{
    private int len;
    private int min;
    private int max;
    public ArrayData4107056019 (int[] A){
        this.A = A;
        this.len = A.length;
        min = A[0];
        max = A[0];

        for(int i=1; i<len; i++){
            if(this.A[i]>max) max = this.A[i];
            if(this.A[i]<min) min = this.A[i];
        }
}
```
### 與rank:2 的比較
減少了變數min,max的更動次數
```java
public class ArrayData4107056006 extends ArrayData{
	private int min = Integer.MAX_VALUE;
	private int max = Integer.MIN_VALUE;
	private int a,b;
	public ArrayData4107056006(int []A){
		for(int i=0;i<A.length-1;i+=2) {
			a = A[i];
			b = A[i+1];
			if(a>b) {
				if(b<min) min = b;
				if(a>max) max = a;
			}else {
				if(a<min) min = a;
				if(b>max) max = b;
			}
		}
		if((A.length%2)!=0) {
			a = A[A.length-1];
			if(a<min) min = a;
			if(a>max) max = a;
		}
	}
}
```

