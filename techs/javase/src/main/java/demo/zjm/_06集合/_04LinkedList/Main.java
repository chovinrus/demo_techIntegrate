package demo.zjm._06集合._04LinkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(1);


//        transient int size = 0;
//        transient LinkedList.Node<E> first;
//        transient LinkedList.Node<E> last;

//        private static class Node<E> {
//        E item;
//        Node<E> next;
//        Node<E> prev;
//
//        Node(Node<E> prev, E element, Node<E> next) {
//            this.item = element;
//            this.next = next;
//            this.prev = prev;
//        }
//    }

//        public LinkedList() {
//        }

//        public static Integer valueOf(int i) {
//            if (i >= Integer.IntegerCache.low && i <= Integer.IntegerCache.high)
//                return Integer.IntegerCache.cache[i + (-Integer.IntegerCache.low)];
//            return new Integer(i);
//        }

//        public boolean add(E e) {
//        linkLast(e);
//        return true;
//    }

//        void linkLast(E e) {
//        final Node<E> l = last;
//        final Node<E> newNode = new Node<>(l, e, null);
//        last = newNode;
//        if (l == null)
//            first = newNode;
//        else
//            l.next = newNode;
//        size++;
//        modCount++;
//    }
    }
}
