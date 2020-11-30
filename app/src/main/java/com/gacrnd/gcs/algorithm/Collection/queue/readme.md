##### 1.假如队列长度容量为N，并且预留一个空的位置作为队列空，满，长度判断标志的条件：

* 队列为空：front == rear；
* 队列满：（rear+1）%N = front；
* 队列元素个数：（rear-front + N）%N;



##### 2.双端队列

* LinkedList、ArrayDeque、LinkedBlockingDeque

  ArrayDequeue，没有加锁，线程不安全

  LinkedBlockingDeque线程安全的双端队列



##### 3.优先级队列 

MessageQueue，PriorityQueue