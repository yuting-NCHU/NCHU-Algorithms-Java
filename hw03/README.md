### 5    IslandCounting4107056005
可去[線程魔法使](https://github.com/liao2000/Algorithms-Meet-Java/tree/master/Homework/HW03_IslandCounting)那裏看題目說明  
明明說是字串，最後才知道是數字，感覺有點被坑了  
雖然有寫無hashmap版，但因為沒時間測試數字範圍，保險一點紙上傳了hashmap版  
但沒關係我還是有第5，我棒棒!  

用註冊node的概念，如果陣列的值不是0就代表此node已被加進去過了  
主要是分4個case，可減少存取變數   
AYBY>兩點皆已註冊過，如果是兩個不同的component(find root不同)，union後島嶼個數減一  
>使用weight-union，以高度(size[])來union   
AYBN->B直接接在A下面，島嶼數不變(因為B新註冊->島嶼數加一，union又減一，直接抵銷)  
ANBY->A直接接在B下面，原因同上  
ANBN->A直接接在B下面，島嶼數加一(新註冊兩點->島嶼數加2，union又減一)  

````java
for(int i=0;i<len;++i) {
	a=Integer.parseInt(A[i])+1;b=Integer.parseInt(B[i])+1; //避免node的序號為0的情況
	if(id[a]>0) {a=find(a);
		if(id[b]>0) {b=find(b);//AYBY
			if(a!=b) {
				if (size[a] < size[b]) id[a] = b; 
			else{id[b] = a;if(size[a] == size[b]) ++size[a];} --islandNum;
			}continue;
		}//AYBN
		id[b]=a;continue;
	}//ANBN
	if(id[b]==0) {id[a]=b;id[b]=b;++size[b];++islandNum;continue;}
	//ANBY
	id[a] = find(b);
}
return islandNum;
````

````java
public int find(int i) {
	while(id[i]!=i) {
		id[i]=id[id[i]];i=id[i];} 
	return i;
}
return islandNum;
  ````
