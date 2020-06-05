
整數陣列中的數字皆不重複，請找出能讓 3 個數加起來合為零的組合有幾個

### [ThreeSum4107056019](https://github.com/liao2000/Algorithms-Meet-Java/tree/master/Homework/HW02_ThreeSum) rank:0  
強者我同學，線程魔法使，根本不是人能看的，第0名實至名歸

### ThreeSum4107056005 rank:8
據我我查，目前最快只有O(N^2)  
先用sort把陣列由小排到大  
第一個for固定一個數 -> A[i]  
用while找兩個數，使三數相加=0   
所以找的目標是第一個數的負數 -> tar=-A[i];  
因為是由小排到大的，所以  
h(head) -> 最小的數，往右移會越來越大  
r(rear) -> 最大的數，往左移會越來越小  
c 	-> 有幾種組合  
````java
	public int T_sum(int[] A) {
		int c=0,h,r,tar,end=A.length-2;
		mSort(A,A.length);
		for(int i=0;i<end;++i) {
			h=i+1; r=end+1; tar=-A[i];
			while(h<r) {
				if(A[h]+A[r]==tar) { ++c;++h;--r;}
				else if(A[h]+A[r]<tar) ++h; //因為小於目標所以h要向右移一個，相加後才會變大
				else --r; //因為大於目標所以r要向左移一個，相加後才會變小
			}
		}
		return c;
	}
````

