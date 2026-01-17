package stack;

import java.util.EmptyStackException;

public class MyStack<T> {

    private Object[] elements;
    private int top;

    public MyStack() {
        elements = new Object[5]; //Početni kapacitet
        top = -1;
    }

    //Dodaje element na vrh stack-a
    public void push(T value) {
        if (top == elements.length - 1) {
            resize();
        }
        elements[++top] = value;
    }

    //Skida i vraća element sa vrha
    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T value = (T) elements[top];
        elements[top--] = null; //Pomaže GC-u
        return value;
    }

    //Vraća element sa vrha bez skidanja
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T) elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    //Povećava kapacitet niza
    private void resize() {
        Object[] newArray = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }

}
