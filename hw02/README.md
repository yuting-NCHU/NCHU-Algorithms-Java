
整數陣列中的數字皆不重複，請找出能有幾種能讓 3 個數加起來合為零的組合有幾個

### 0 [ThreeSum4107056019](https://github.com/liao2000/Algorithms-Meet-Java/blob/master/Homework/HW02_ThreeSum/ThreeSum4107056019.java)
真不愧是線程魔法使，寫出來的code根本不是給人看的，難怪這麼好心公開程式碼，是我我也不會想抄，第0名實至名歸

### 8 ThreeSum4107056005  
據我我查，目前最快只有O(N^2)  
先用sort把陣列由小排到大  
第一個for固定一個數 -> A[i]  
第二個for找兩個數，使三數相加=0   
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
				else --r;
			}
		}
		return c;
	}
````

