package datastructure;

public class stack<E> {

    private static final int MAX = 100;

    private E[] elements;
    private int top;

    public stack() {
        elements = (E[])new Object[MAX];
        this.top = -1;
    }
}
