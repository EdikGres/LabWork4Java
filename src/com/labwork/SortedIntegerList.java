package com.labwork;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;

/*
    Можно оптимизировать используя расчёты по последнему элементу. ( нужно его сохранять )
    ????
    for (int i = 0; i < size; i++) {
            tmp = list.get(i);
    Получается проход в проходе?
    ????

    Добавить инициализацию с помощью массива int или дженериков
 */

public class SortedIntegerList {
    private final LinkedList<Integer> list;
    private final boolean repeat;
    private int size;

    public SortedIntegerList(boolean repeat) {
        this.repeat = repeat;
        this.list = new LinkedList<Integer>();
        this.size = 0;
    }

    public SortedIntegerList add(int a) {
        if (size == 0) {
            list.add(a);
            size++;
            return this;
        }
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            int tmp = it.next();
            if (a == tmp && repeat)
                return this;
            if (a < tmp) {
                it.previous();
                it.add(a);
                size++;
                return this;
            }
        }
        list.addLast(a);
        size++;
        return this;
    }

    public SortedIntegerList remove(int a) {
        if (size == 0) return this;
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            int tmp = it.next();
            if (a == tmp) {
                it.remove();
                size--;
                if (repeat) //optimization!
                    return this;
            }
        }
        return this;
    }

    public int getElement(int index) {
        return list.get(index);
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "SortedIntegerList{" +
                "list=" + list +
                ", repeat=" + repeat +
                ", size=" + size +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SortedIntegerList)) return false;
        SortedIntegerList that = (SortedIntegerList) o;
        return repeat == that.repeat && size == that.size && Objects.equals(list, that.list);
    }

}
