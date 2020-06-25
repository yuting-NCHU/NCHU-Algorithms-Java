# rank: 11
# 題目
找出一個未出現在陣列中的最小正整數
# 解
### 初版O(N)
最快的，之後不管怎麼改都變慢  
用兩個for迴圈->2N  
第一個for:先記錄有那些數字有出現  
第二個for:從1開始找，看有哪個數字沒有就return  
 
```java
public int min(int[] array) {
		int len=array.length,i=0,j;
		int[] mark=new int[len+1];    //↓只能在這裡加速
		for(;i<len;++i) {j=array[i]; if(0<j && j<=len) mark[j]=1;}
		for(i=1;i<=len;++i) if(mark[i]==0) return i;
		return len+1;
	}
```
推測負數應該也是蠻多的  
```java
if(0<j && j<=len) 會比 if(j<=len && 0<j)快
```
但還是一直在40幾名  
想破頭想了很多算法   
但是都比初版慢  
最後被我發現一個小地方  
### Data Type
![](https://i.imgur.com/fe7weYC.png)  
int 是 4 byte  
但boolean 只有 1 bit!!!!  
整整差了32倍!!!  
把mark[]改成boolean後就進前十了  
(真的不知道我花了這麼多時間想都在幹嘛)  
但最後發現用網路上的答案是最快的...  
ㄜ...   
<img src="https://i.imgur.com/OLhaNUp.jpg" width="600">  

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

### 6/14
好像反而更慢了  
看來盡量不要用到更動變數比較好  

### 6/16
唉，終於知道為什麼會有崩潰仔出現了  
這種越改越慢的感覺  
這種根本不知道自己差在哪裡的感覺  
重點是我照線程魔法使的做法只會越改越慢啊啊啊啊   
![](https://i.imgur.com/GRCCaTE.png)  
比資料結構還崩潰==  
資料結構上網查就可以了  
演算法寫出來很簡單，但沒有最優解...  


### 6/18 
原來是我改錯方向了，現在排名終於正常了  
![](https://i.imgur.com/8RzgKc2.png)   

網路上的方法都很爛，都查不到我想要的...  
是說這次的作業也用不到甚麼算法啦，所以網路上的資料很少  
算了，至少也知道類似題型要怎麼解  
以後面試或許有用   

### 6/24
結果今天又從前10掉到40幾  
我已經換成網路上的code了，看看結果如何   

----------晚上補更---------------  
MPI4107056005,Correct,0.124775  
MPI4107056005_2,Correct,0.129620  
MPI4107056005_3,Correct,0.104336 (抄網路上的)   
MPI4107056005_4,Correct,0.123457  
MPI4107056005_5,Correct,0.117357 (抄網路上的)  

我決定賭一把了  
賭明天的測資會不會跟今天類似  
衝鴨!!!!!!!!!  
為了追求穩定  
使用這種測資是必須的!  
拜託明天不要又給我換測資喔   

### 6/25
感謝助教  
我賭贏了  
11   MPI4107056005                   stats: Correct                                     time: 0.111423  
這次期末考有夠ㄙㄨㄟ  
猜題都沒中，看了都沒考  
只能吃老本(憑上課印象)    
所以說認真上課真的很重要    
然後有些明明寫對，後來又改成錯的，每次考完才發現    
![](https://i.imgur.com/XbWMQoR.png)  
(是什麼蒙蔽了我的雙眼)  

這次作業讓我感受到  
我的運氣又回來了!!  
![](https://i.imgur.com/XJLioDu.png)  
相信自己的第六感  

之前資料結構是靠作業救回來的  
這次演算法就靠作業拉分了  
![](https://i.imgur.com/vCRDyWL.png)  

