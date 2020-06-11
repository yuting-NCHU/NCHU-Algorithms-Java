### rank:6
### 原本的垃圾O(N^3)，還會有溢位問題
窮舉任意兩點  
把條件y1/x1=y2/x2交叉相乘後改成y1x2=y2x1
````java
public boolean checkPCL(int[][] array) {
  for(int i=array.length-1; i>-1; --i){
    for(int j=i-1; j>-1; --j){
      for(int k=j-1; k>-1; --k){
        if((array[i][1]-array[j][1])*(array[j][0]-array[k][0])==(array[j][1]-array[k][1])*(array[i][0]-array[j][0])) return true;
      }
    }
  }
  return false;
}
````
### 使用[hashmap](https://www.geeksforgeeks.org/internal-working-of-hashmap-java/)改良後的O(N^2)
據我所查，目前O(N^2)已是極限  
先固定住一點A，另外窮舉其他點B,C,D,E......  
如果A,B的斜率=A,C的斜率就代表三點共線  
利用hashmap可快速得知斜率是否相同 O(1)  
在放入hashmap裡時，如果陣列裡已經有值就代表重複了  
````java
public boolean checkPCL(int[][] array) {
  myHash hash;
  for(int i=array.length-1;i>-1;--i) { //先固定住一點A
    hash=new myHash(2*i); //每次更換固定點A都要用新的hashmap
    flag=false; //flag 也要重新初始化
    for(int j=i-1;j>-1;--j) { //窮舉其他點B,C,D,E...
      x=(array[i][0]-array[j][0]); 
      if(x==0) { //為了避免算斜率時y/x會除到0而做的例外處理
        if(flag==false) flag=true; //表示有一個x=0
        else return true; //表示有兩個x=0，斜率相同，直接return
      }else { //put的function會回傳ture or false，如果是true就代表斜率有重複
        if(hash.put((double)(array[i][1]-array[j][1])/x)) return true;
      }
    }
  }
  return false;
}
 ````
### 精度問題
#### [丟失精度原因](https://www.jianshu.com/p/f9d22220cb23)
二進制無法精確表示某些小數  
就像我們無法把1/3表示成小數一樣，因為會無限循環1.3333333333333....  
同理，0.9表示成二進制數：

0.9*2 = 1.8 取整數部分：1

0.8*2 = 1.6 取整數部分：1

0.6*2 = 1.2 取整數：1

0.2*2 = 0.4 取整數：0

0.4*2 = 0.8 取整數：0

0.8*2 = 1.6 取整數：1

。。。。

0.9二進製表示為（從上往下）：1100100100100.......

注意：上面的計算過程循環了，也就是說乘以2永遠不能消滅小數部分，這樣算法將無限下去。
顯然，小數的二進製表示有時是不能精確的，這也是浮點型出現精度丟失問題的主要原因。

但整數轉換成二進位不會有精度丟失的問題  

#### 結論
double在整數相除之間不會有精度問題，此測資剛好符合
