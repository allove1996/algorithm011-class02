学习笔记
### HashMap的put方法小结
HashMap就是用来存放简直对，这次主要分析了java的put方法；
put方法的实现总共分三步，第一步，初始化tab；第二步，put值；第三步，返回旧值；

第一步，初始化tab主要是为了防止table为空的情况；初始化只要是通过resize()方法
```
 if ((tab = this.table) == null || (n = tab.length) == 0) {
            n = (tab = this.resize()).length;
        }
```
resize（）方法，主要的工作是把旧的table中的值放到新的table中；

第二步，put值；
put值分两种情况，1、是新值且不存在hash碰撞的情况；2、存在hash碰撞的情况；

1、新值且不存在hash碰撞的验证方式，是通过key的hash值对table的length进行与操作得到
```
if ((p = tab[i = n - 1 & hash]) == null) {
            tab[i] = this.newNode(hash, key, value, (HashMap.Node)null);
        }
```
2、如果存在hash碰撞，则又分为三种情况；
第一种，位置相同，key相等；第二种，位置相同，key不等，但是链表长度超过ThreadHold，也就是说
节点是以树节点的形式存储的，也就是说链表进行过树化；第三种，位置形同，key不等，链表长度
没有超过ThreadHold；
```
if (((HashMap.Node)p).hash == hash && ((k = ((HashMap.Node)p).key) == key || key != null && key.equals(k))) {
                e = p;
            } else if (p instanceof HashMap.TreeNode) {
                e = ((HashMap.TreeNode)p).putTreeVal(this, tab, hash, key, value);
            } else {
                int binCount = 0;

                while(true) {
                    if ((e = ((HashMap.Node)p).next) == null) {
                        ((HashMap.Node)p).next = this.newNode(hash, key, value, (HashMap.Node)null);
                        if (binCount >= 7) {
                            this.treeifyBin(tab, hash);
                        }
                        break;
                    }

                    if (((HashMap.Node)e).hash == hash && ((k = ((HashMap.Node)e).key) == key || key != null && key.equals(k))) {
                        break;
                    }

                    p = e;
                    ++binCount;
                }
            }
```
第三步，返回旧值；
```
if (e != null) {
                V oldValue = ((HashMap.Node)e).value;
                if (!onlyIfAbsent || oldValue == null) {
                    ((HashMap.Node)e).value = value;
                }

                this.afterNodeAccess((HashMap.Node)e);
                return oldValue;
            }
```
这三步之后，还有一个是对HashMap容量的校验
```
 ++this.modCount;
        if (++this.size > this.threshold) {
            this.resize();
        }
```