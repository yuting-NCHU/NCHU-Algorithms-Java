### 5    IslandCounting4107056005
可去[線程魔法使](https://github.com/liao2000/Algorithms-Meet-Java/tree/master/Homework/HW03_IslandCounting)那裏看題目說明
明明說是字串，最後才知道是數字，感覺有點被坑了  
但沒關係我還是有第5，我棒棒!  
````java
for(int i=0;i<len;++i) {
	Aroot=map.get(A[i]);Broot=map.get(B[i]);
	if(Aroot>-1) {Aroot=find(Aroot);
		if(Broot>-1) {Broot=find(Broot);//AYBY
			if(Aroot!=Broot) {
				if (size[Aroot] < size[Broot]) id[Aroot] = Broot; 
			else{id[Broot] = Aroot;if(size[Aroot] == size[Broot]) ++size[Aroot];}
				--islandNum;
			}continue;
		}//AYBN
		id[nodeNum]=Aroot;map.put(B[i], nodeNum++);continue;
	}//ANBN
	if(Broot<0) {
		map.put(A[i], nodeNum++);id[nodeNum-1]=nodeNum;id[nodeNum]=nodeNum;++size[nodeNum];
		map.put(B[i], nodeNum++);++islandNum;continue;}
	//ANBY
	id[nodeNum] = find(Broot);map.put(A[i], nodeNum++);
}
return islandNum;
  ````
