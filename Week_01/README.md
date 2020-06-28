## 学习笔记
先大概整理一下老师讲的内容：

* Chunk it up
* Deliberate Practicing 
* Feedback

### 算法和数据结构总览
数据结构
* 一维
  * 基础：数组（array），链表（linked list）
  * 高级：栈（stack），队列（Queue）,双端队列（deque），集合（set），映射（map），etc
* 二维
  * 基础：树（tree），图（graph）
  * 高级：二叉搜索树binary search tree（red black tree, AVL)，堆（heap),并查集（disjoint set),字典树（trie） etc；
* 特殊
  * 位运算， 布隆过滤器；
  * LRU Cache

算法
* if else ,swith
* for , while  loop
* 递归(Recursion)；
* 搜索(search)，广度优先(BFS)，深度优先(DFS),A*；
* 动态规划(Dynamic Programming)；
* 二分查找(Binary Search)；
* 贪心(Greedy)
* 数学(Math)，几何(Geometry)

切题方式
* Clarification
* Possible Solutions
    * compare(time/space)
    * optimal（加强）
* Coding(多写)
* Test cases

五毒神掌
* 刷题第一遍：
    * 5分钟：读题+思考；
    * 直接看解法：注意！多解法，比较解法优劣；
    * 背诵，默写好的解法
* 刷题第二遍
    * 马上自己写 --> LeetCode提交
    * 多种解法比较、体会 --> 优化
* 刷题第三遍
    * 过了一天后，再重复做题；
    * 不同解法的熟练程度 -> 专项练习
* 刷题第四遍
    * 过了一周，反复回来练习相同的题目；
* 刷题第五遍
    * 面试前一周，恢复性训练；
    
### 时间和空间复杂度
常见的时间复杂度
* O(1)
* O(n)
* O(logn)
* O(n^2)
* O(n^3)
* O(n!)
* O(2^n)
注意：只看最高时间复杂度的运算

主定理
* Binary Search, O(logn)
* Binary tree traversal, O(n)
* Optimal sorted matrix search, O(n)
* Merge Sort, O(nlogn)

空间复杂度
* 数组的长度
* 树的深度

### 数组、链表和跳表
数组
操作分析
1. 随机访问时间复杂度O(1)
2. 插入元素最坏时间复杂度O(n)，最好时间复杂度O(1)，平均时间复杂度O(n);
3. 删除元素最坏时间复杂度O(n)，最好时间复杂度O(1)，平均时间复杂度O(n);

链表 操作分析
1. 访问某个元素，时间复杂度O(n)
2. 知道位置后，插入删除一个元素的时间复杂度O(1);

链表操作注意事项：
1. 理解指针的含义，链表的从狭义上来说，就是一个节点，节点的内容是一份数据和一份内存地址；
2. 警惕指针丢失和内存泄漏，特别是预防next指针的丢失；
3. 注意边界条件处理

跳表
在元素有序的情况下，对链表建立索引，就是跳表；可以把有序链表的查询时间复杂度加速到 log(n)

常见的加速方式
1. 升维
2. 空间换时间

###栈、队列
栈，先入后出；
* 添加、删除操作时间复杂度，O(1)
* 查询操作, O(n);

队列，先入先出；
* 添加、删除操作时间复杂度，O(1)
* 查询操作, O(n);

priority queue
1. 插入操作，O（1）；
2. 取出操作，O(logn) -按照元素的优先级取出

------
###第一周的个人总结
基础 关于数组和链表

所有数据结构的核心是数组和链表，高级的数据结构是都是在数组和链表的基础上进行封装；
数组是一段连续的内存单元，随机访问的时间复杂度是O（1），如果要查询某个元素，时间复杂度是O（n）；
链表是一段零散的内存单元，即使随机访问某个元素，时间复杂度也是O(n);
为了提高二者的查询效率，所以产生了树这种结构。我理解的跳表的结构有点类似于一颗B+树；

数组和链表的操作的自由度很大，可以随意修改元素的值，为了实现某些需求时，可以让代码更严谨，更少bug，
所以有的时候需要一些操作受限的数据结构，所有栈和队列就是应对这种需求的，栈是先入后出，队列是先入先出。比如实现浏览器的前进后退，需要用到
栈，Mq中用到的就是队列的内容。

一个功能的可以有多种实现方式，怎样评判哪种实现方式最好，由此引出时间空间复杂度分析，分析的目的是
判断随着数据量的增加指令执行次数的变化，关注随n增大时代码的执行行数。

在学习老师的课程和做题的过程中，到目前为止，一直在思考和总结的有两个，一个是怎样找到重复子问题，
另一个是怎样找到数据之间的最近相关性。可能随着做题量的增加，这两点就想的越清楚吧。
    
使用deque方法
```java
Deque<String> deque = new LinkedList<>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addLast("c");
        System.out.println(deque);

        String str = deque.removeFirst();
        String str1  = deque.removeLast();
        System.out.println(str);
        System.out.println(str1);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.removeLast());
        }
        System.out.println(deque);
```

