package com.linkedlist;

import java.util.Random;

public class SkipList<T extends Comparable<T>,U> {

    public class Node {
        public T key;
        public U value;
        public long level;
        public Node next;
        public Node down;

        public Node(T key, U value, long level, Node next, Node down) {
            this.key = key;
            this.value = value;
            this.level = level;
            this.next = next;
            this.down = down;
        }
    }

    private Node head;
    private Random _random;
    private long size;
    private double _p;

    private long level(){
        long level =0;
        while(level <= size && _random.nextDouble() < _p){
            level++;
        }
        return  level;
    }

    public SkipList (){
        head = new Node(null,null,0,null,null);
        _random = new Random();
        size = 0;
        _p = 0.5;
    }

    public void add(T key, U value){
        long level = level();
        if(level > head.level){
            head = new Node(null,null,level,null,head);
        }
        Node curr = head;
        Node last = null;

        while(curr != null){
            if(curr.next == null || curr.next.key.compareTo(key) > 0){
                if(level >= curr.level){
                    Node newNode = new Node(key,value,curr.level,curr.next,null);
                    if(last != null && last.down != null){
                        last.down = newNode;
                    }
                    curr.next = newNode;
                    last =newNode;
                }
                curr = curr.down;
                continue;
            }else if(curr.next.key.equals(key)){
                curr.next.value = value;
                return;
            }
            curr = curr.next;
        }
        size++;
    }

    public boolean containsKey(T key){
        return get(key) != null;
    }

    public U get(T key){
        Node cur = head;
        while (cur != null){
            if(cur.next == null || cur.next.key.compareTo(key) > 0){
                cur = cur.down;
                continue;
            }else if(cur.next.key.equals(key)){
                return  cur.next.value;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public String toString() {
        return "SkipList{" +
                "head=" + head +
                ", _random=" + _random +
                ", size=" + size +
                ", _p=" + _p +
                '}';
    }
}
