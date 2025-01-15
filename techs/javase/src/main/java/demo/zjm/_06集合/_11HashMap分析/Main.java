package demo.zjm._06集合._11HashMap分析;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        integerIntegerHashMap.put(1, 2);

//        /**
//             * Basic hash bin node, used for most entries.  (See below for
//             * TreeNode subclass, and in LinkedHashMap for its Entry subclass.)
//             */
//            static class Node<K,V> implements Map.Entry<K,V> {
//                final int hash;
//                final K key;
//                V value;
//                Node<K,V> next;
//
//                Node(int hash, K key, V value, Node<K,V> next) {
//                    this.hash = hash;
//                    this.key = key;
//                    this.value = value;
//                    this.next = next;
//                }
//
//                public final K getKey()        { return key; }
//                public final V getValue()      { return value; }
//                public final String toString() { return key + "=" + value; }
//
//                public final int hashCode() {
//                    return Objects.hashCode(key) ^ Objects.hashCode(value);
//                }
//
//                public final V setValue(V newValue) {
//                    V oldValue = value;
//                    value = newValue;
//                    return oldValue;
//                }
//
//                public final boolean equals(Object o) {
//                    if (o == this)
//                        return true;
//                    if (o instanceof Map.Entry) {
//                        Map.Entry<?,?> e = (Map.Entry<?,?>)o;
//                        if (Objects.equals(key, e.getKey()) &&
//                            Objects.equals(value, e.getValue()))
//                            return true;
//                    }
//                    return false;
//                }
//            }

//        transient Node<K,V>[] table;

        //static final int hash(Object key) {
        //        int h;
        //        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        //    }


//        public V put(K key, V value) {
//                return putVal(hash(key), key, value, false, true);
//        }

        //final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
        //                   boolean evict) {
        //        Node<K,V>[] tab; Node<K,V> p; int n, i;
        //        if ((tab = table) == null || (n = tab.length) == 0)
        //            n = (tab = resize()).length;
        //        if ((p = tab[i = (n - 1) & hash]) == null)
        //            tab[i] = newNode(hash, key, value, null);
        //        else {
        //            Node<K,V> e; K k;
        //            if (p.hash == hash &&
        //                ((k = p.key) == key || (key != null && key.equals(k))))
        //                e = p;
        //            else if (p instanceof TreeNode)
        //                e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        //            else {
        //                for (int binCount = 0; ; ++binCount) {
        //                    if ((e = p.next) == null) {
        //                        p.next = newNode(hash, key, value, null);
        //                        if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
        //                            treeifyBin(tab, hash);
        //                        break;
        //                    }
        //                    if (e.hash == hash &&
        //                        ((k = e.key) == key || (key != null && key.equals(k))))
        //                        break;
        //                    p = e;
        //                }
        //            }
        //            if (e != null) { // existing mapping for key
        //                V oldValue = e.value;
        //                if (!onlyIfAbsent || oldValue == null)
        //                    e.value = value;
        //                afterNodeAccess(e);
        //                return oldValue;
        //            }
        //        }
        //        ++modCount;
        //        if (++size > threshold)
        //            resize();
        //        afterNodeInsertion(evict);
        //        return null;
        //    }

        //final Node<K,V>[] resize() {
        //        Node<K,V>[] oldTab = table;
        //        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        //        int oldThr = threshold;
        //        int newCap, newThr = 0;
        //        if (oldCap > 0) {
        //            if (oldCap >= MAXIMUM_CAPACITY) {
        //                threshold = Integer.MAX_VALUE;
        //                return oldTab;
        //            }
        //            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
        //                     oldCap >= DEFAULT_INITIAL_CAPACITY)
        //                newThr = oldThr << 1; // double threshold
        //        }
        //        else if (oldThr > 0) // initial capacity was placed in threshold
        //            newCap = oldThr;
        //        else {               // zero initial threshold signifies using defaults
        //            newCap = DEFAULT_INITIAL_CAPACITY;
        //            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        //        }
        //        if (newThr == 0) {
        //            float ft = (float)newCap * loadFactor;
        //            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
        //                      (int)ft : Integer.MAX_VALUE);
        //        }
        //        threshold = newThr;
        //        @SuppressWarnings({"rawtypes","unchecked"})
        //            Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        //        table = newTab;
        //        if (oldTab != null) {
        //            for (int j = 0; j < oldCap; ++j) {
        //                Node<K,V> e;
        //                if ((e = oldTab[j]) != null) {
        //                    oldTab[j] = null;
        //                    if (e.next == null)
        //                        newTab[e.hash & (newCap - 1)] = e;
        //                    else if (e instanceof TreeNode)
        //                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
        //                    else { // preserve order
        //                        Node<K,V> loHead = null, loTail = null;
        //                        Node<K,V> hiHead = null, hiTail = null;
        //                        Node<K,V> next;
        //                        do {
        //                            next = e.next;
        //                            if ((e.hash & oldCap) == 0) {
        //                                if (loTail == null)
        //                                    loHead = e;
        //                                else
        //                                    loTail.next = e;
        //                                loTail = e;
        //                            }
        //                            else {
        //                                if (hiTail == null)
        //                                    hiHead = e;
        //                                else
        //                                    hiTail.next = e;
        //                                hiTail = e;
        //                            }
        //                        } while ((e = next) != null);
        //                        if (loTail != null) {
        //                            loTail.next = null;
        //                            newTab[j] = loHead;
        //                        }
        //                        if (hiTail != null) {
        //                            hiTail.next = null;
        //                            newTab[j + oldCap] = hiHead;
        //                        }
        //                    }
        //                }
        //            }
        //        }
        //        return newTab;
        //    }
    }
}
