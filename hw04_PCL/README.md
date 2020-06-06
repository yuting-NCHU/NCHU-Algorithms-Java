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
### 使用hashmap改良後的O(N^2)
先固定住一點A，另外窮舉其他點B,C,D,E......  
如果A,B的斜率=A,C的斜率就代表三點共線  
利用hashmap可快速得知斜率是否相同 O(1)  
在放入hashmap裡時，如果陣列裡已經有值就代表重複了  
````java
public boolean checkPCL(int[][] array) {
  myHash hash;
  for(int i=array.length-1;i>-1;--i) {
    hash=new myHash(2*i); //每次更換固定點A都要用新的hashmap
    flag=false; //flag 也要重新初始化
    for(int j=i-1;j>-1;--j) {
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
double在整數相除之間不會有精度問題，此測資剛好符合
