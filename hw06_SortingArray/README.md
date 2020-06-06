### rank:7
這次的測資是大家一起出的  
原本我還很興奮，想說大家可以互相攻擊對方，猜對方的測資，寫出獨特的算法  
結果發現只有我陰險，大家都隨便亂出，ㄜ... 
### 我就陰險:thumbsup:
最後就是比運氣了，排序也就那幾種，我覺得用quick sort應該是最快的，可是不知道為什麼，明明我自己測都沒問題卻一直有記憶體存取錯誤，最後只能用穩穩的merge sort


### divid的部分
小技巧，排的區段小時可用insert sort  
因為耀中說當排的區段很小時，insert sort 是無敵的  
````java
protected void compute(int low, int high) {
	if (high - low < 30) { //insert sort
		for (int i = low + 1; i < high; ++i)
			for (int j = i; j > low; --j)
				if (A[j] < A[j - 1]) {
					temp = A[j];
					A[j] = A[j - 1];
					A[j - 1] = temp;
				} else
					break;
	} else {
		int mid = ((high + low) >> 1); //右移一位，代表除2，現在被演算法搞到乘除是2的次方都用位移了，冏
		compute(low, mid);
		compute(mid, high);
		merge(low, mid, high);
	}
}
````
### merge的部分
````java
private void merge(int low, int middle, int high) {
	if (A[middle - 1] <= A[middle]) //如果已排好就直接return
		return;
	int[] copy = new int[high - low];
	System.arraycopy(A, low, copy, 0, copy.length);
	int copyLow = 0, copyHigh = high - low, copyMiddle = middle - low;
	for (int i = low, p = copyLow, q = copyMiddle; i < high; i++)
		if (q >= copyHigh || (p < copyMiddle && copy[p] < copy[q]))
			A[i] = copy[p++];
		else
			A[i] = copy[q++];
}
````
### 出測資的建議
因為有如果已排好就直接return的功能  
所以可以分兩段出\[1\~10000\]\[10001\~20000\]  
然後把\[1\~10000\]和\[10001\~20000\]分別隨機打亂   
其實很簡單，比如前半段，只要把ramdon的範圍設成\[1\~10000\]就可以了  
這樣等到merge到只剩這兩段時就可直接return  
當然你也可以分成四段、八段之類的，隨你出  
ex:\[1\~5000\]\[5001\~10000\]\[10000\~15000\]\[15000\~20000\]分別打亂  
