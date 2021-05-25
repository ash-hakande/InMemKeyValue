package com.company.Models;

public class Pair<E1,E2> {

    E1 item1;
    E2 item2;

    public Pair(E1 item1, E2 item2)
    {
        this.item1 = item1;
        this.item2 = item2;
    }

    public E1 getItem1() {
        return item1;
    }

    public E2 getItem2() {
        return item2;
    }

    @Override
    public boolean equals(Object p)
    {
        if(! (p instanceof Pair)) return false;
        return ( ((Pair<?, ?>) p).item1.equals(item1) && ((Pair<?, ?>) p).item2.equals(item2));
    }


}
