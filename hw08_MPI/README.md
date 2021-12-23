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
