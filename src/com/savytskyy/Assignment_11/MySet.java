package com.savytskyy.Assignment_11;

import java.util.Iterator;

public class MySet<T> implements Iterable<T> {


    private static class Node {
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }
    }

    private Node[] buckets;
    private int size = 0;

    public MySet(int size) {
        this.buckets = new Node[size];
    }

    public MySet() {
        this(16);
    }

    public void add(T elem) {
        int bucket = getBucket(elem);
        Node existElem = findElem(elem, bucket);

        if (existElem != null) {
            existElem.value = elem;
        } else {
            Node n = new Node(elem);
            n.next = buckets[bucket];
            buckets[bucket] = n;
            ++size;
        }
    }

    public boolean contains(T elem) {
        int bucket = getBucket(elem);
        Node existElem = findElem(elem, bucket);
        return (existElem != null);
    }

    private int getBucket(T elem) {
        int hash = elem.hashCode();
        return (hash >= 0 ? hash : -hash) % buckets.length;
    }

    private Node findElem(T elem, int bucket) {
        for (Node cur = buckets[bucket]; cur != null; cur = cur.next) {
            if (cur.value.equals(elem)) {
                return cur;
            }
        }
        return null;
    }


    public T find(T elem) {
        int bucket = getBucket(elem);
        Node existElem = findElem(elem, bucket);
        return existElem != null? (T)existElem.value:null;
    }

    public T get(int index) {
        int i = 0;
        for (T t : this) {
            if (i==index) return t;
            i++;
        }
        return null;
    }



    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int curBucket = -1;
            private Node cur = null;

            @Override
            public boolean hasNext() {
                if (cur != null && cur.next != null) {
                    cur = cur.next;
                    return true;
                }
                for (++curBucket; curBucket < buckets.length; ++curBucket) {
                    if (buckets[curBucket] != null) {
                        cur = buckets[curBucket];
                        return true;
                    }
                }
                return false;
            }

            @Override
            public T next() {
                return (T) cur.value;
            }
        };
    }







/* version 00
     public void add(T elem) {
        int hash = elem.hashCode();
        int bucket =hash% buckets.length;
        appendOrReplace(elem, bucket);
    }

    private void appendOrReplace(T elem, int bucket) {
        Node prev=null;
        for (Node cur = buckets [bucket];cur!=null;cur = cur.next){
            if (cur.value.equals(elem)) {
                cur.value = elem;
                return;
            }
            prev=cur;
        }
        if (prev == null) {
            buckets[bucket] = new Node(elem);
        } else {
            prev.next = new Node(elem);
        }
    }
 */


}
