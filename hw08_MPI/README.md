# 題目
找出一個未出現在陣列中的最小正整數
# log
### 6/10
越簡單的越難  
雖然寫出來很容易，但想要比其他人快很難  
要怎麼拉開與別人的差距呢  
也許我也該加入線程魔法使的行列?  

不..ㄅ行，我有我的堅持  
(主要是懶得去學)  

### 6/12
唉不行啊這次太簡單了，掉出了前10名之外  
可不能像slash一樣比運氣了  
我決定偷師線程魔法使的技藝  
轉職成線程練習生!  
希望真的能像線程魔法使說的一樣能加快速度...  
話說這次最快就是O(N)了吧  
在我前面的是怎樣?全都線程魔法使?  

----------------晚上補更-----------------------  
ㄜ...魔法使說好的加速呢....  
為什麼我用線程反而更慢惹QQ  
轉職失敗!  
7&emsp;&ensp;MPI4107056005(無thread)&ensp;&emsp;&emsp;stats: Correct&emsp;&emsp;time: 0.174758   
29&emsp;MPI4107056005_2(8 thread)&nbsp;&nbsp;&emsp;stats: Correct&emsp;&emsp;time: 0.344303     
37&emsp;MPI4107056005_3(16 thread)&emsp;stats: Correct&emsp;&emsp;time: 0.417257   
難道就不能讓我享受一下用線程加速的效果嗎，好想第0名，我都沒有第0名過耶...     
不過我之前就覺得奇怪，網路上是說thread只會**模擬**平行處理而已，實際上應該不會變快才對  
所以我才一直沒用這個方法  
不然就是耀中的server很高級真的能平行跑，但被助教發現了我們的陰謀，所以變得不能用thread加速  
好吧我還是老實點自己想有什麼算法可以加速ㄅ...   

### 6/13
今天發現網路上居然有答案可以抄抄  
感覺很像trhee-way quick sort  
邊排序邊找這樣  
```java
int l = 0;
int r = array.length; 
while (l < r) {
	if (array[l] == l + 1) {
		l++;
	} else if (array[l] > r || array[l] <= l || array[array[l] - 1] == array[l])
	{
		array[l] = array[--r];

	} else //但這裡直接下去，因為要交換(排序)，浪費很多效能
	{
		temp = array[l];
		array[l] = array[array[l] - 1];
		array[temp - 1] = temp;

	}
}
return l + 1;
```
果然很慘  
44   MPI4107056005_5    stats: Correct    time: 0.357827  

但對已排好的測資來說是最快的  
這給了我靈感  
剛剛稍微改了一下程式碼  
best case 是已排好的測資  
明天來看看結果如何  



