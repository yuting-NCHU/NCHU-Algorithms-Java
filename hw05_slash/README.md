題目說明依舊轉給[線程魔法使](https://github.com/liao2000/Algorithms-Meet-Java/tree/master/Homework/HW05_Slash)  
這是我轉成位移狂魔之前的code  
其他就沒什麼技術性了，純粹拚運氣
````java
public int slash_min(int[] A) {
  lo=0;hi=A.length;mid=hi/2; //除2應該要使用位移的
  while(A[mid+1]>A[mid]) {
    if(A[mid]<A[0]) hi=mid;
    else lo=mid;
    mid=(lo+hi)/2; //要用位移!!!
  }
  return A.length-mid-2;
}
````
