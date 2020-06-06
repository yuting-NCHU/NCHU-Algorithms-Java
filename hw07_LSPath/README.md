這次的作業出現了崩潰仔，但我相信不是資工系的，因為我們都經歷過資料結構，心臟夠強    

但我覺得這次有耀中的誤導，所以提高了難度  

比如說可import的packet，我整個??，那個Collection到底是幹甚麼用的?還有BFS不是要用Queqe做嗎?import Stack幹嘛，還特地去問助教  
![email](email.PNG)  
但我後來想說者這可能是考題的一部份，所以就自己實作了  

至於Collection和Stack想了很久看能不能用在我的code裡面，結果發現更本用不到
而ArrayList可用來做[adjacency list](https://www.programiz.com/dsa/graph-adjacency-list)  
![adjacency_list](adjacency list.PNG)

還有耀中說需要每個點都做BFS，我就覺得疑惑為什麼一定要每個點都做，害我一開始對自己的做法感到懷疑，想說有什麼case是我忽略的  

我google了兩天，一直都找不到我想要的答案，精確一點的就Dijkstra's algorithm，近似演算法只找到針對千萬或上億個node級別的論文  

直到我發現了一篇文章，知道了我的作法的例外case長什麼樣，幸好老師很nice還給誤差範圍，我估了一下誤差大概是多少，應該有在誤差範圍內   
但還是希望最後不要突然間有bug(拜託)，希望助教會定期換測資，尤其延長繳交時間又增加了我焦慮的時間，好想早死早超生  
之後我會把查到的連結放在這裡->  
