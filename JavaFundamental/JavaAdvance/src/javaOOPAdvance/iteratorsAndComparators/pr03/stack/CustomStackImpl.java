package javaOOPAdvance.iteratorsAndComparators.pr03.stack;

import javaOOPAdvance.iteratorsAndComparators.pr03.iterators.StackIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

public class CustomStackImpl implements CustomStack {
    private static final int DEFAULT_CAPACITY = 16;
    private int size = 0;
    private Integer elements[];

    public CustomStackImpl() {
        elements = new Integer[DEFAULT_CAPACITY];
    }

    @Override
    public void push(int e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }

    @Override
    public Integer pop() {
        Integer element = elements[--size];
        elements[size] = null;
        return element;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator(elements).iterator();
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Iterator<Integer> iterator = this.iterator();
        while (iterator.hasNext()){
            action.accept(iterator.next());
        }
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
}
