package com.linkedlist;

public class SkipListsDriver {

    public static void main(String[] args) {
        SkipList s = new SkipList();
        s.add(1,100);
        s.add(2,200);
        s.add(3,300);

        System.out.println("skip list : "+ s.toString());
    }
}
