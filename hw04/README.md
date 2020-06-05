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
