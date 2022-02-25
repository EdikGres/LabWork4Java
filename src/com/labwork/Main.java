package com.labwork;

import java.util.Arrays;
import java.util.Random;

/*
    Тесты представленные ниже в коде неполные и плохо написаны, поскольку не было времени изучить junit5!
    TODO:
    1.add maven
    2.add Junit5 tests
    3.optimize SortedIntegerList
 */

public class Main {

    public static void main(String[] args) {
        System.out.println("-----Test module-----");

        //add false test
        System.out.println("test add(false repeat):");
        Random rand = new Random();
        SortedIntegerList list = new SortedIntegerList(false);
        int[] arr = new int[50];
        for (int i = 0; i < 50; i++) {
            int tmp = rand.nextInt() % 200;
            list.add(tmp);
            arr[i] = tmp;
        }
        Arrays.sort(arr);
        for (int i = 0; i < 50; i++) {
            if (list.getElement(i) != arr[i]) {
                System.out.println("\tTEST FAILED");
                return;
            }
        }
        System.out.println("\tTEST PASSED");

        //add true test
        System.out.println("test add(true repeat):");
        SortedIntegerList list2 = new SortedIntegerList(true);
        // { -5, -5, 1, -5, 5, 1, -1, -7} give
        // { -7, -5, -1, 1, 5 } expect
        list2.add(-5).add(-5).add(1).add(-5).add(5).add(1).add(-1).add(-7);
        int[] arr2 = {-7, -5, -1, 1, 5};
        for (int i = 0; i < list2.getSize(); i++) {
            if(arr2[i] != list2.getElement(i)) {
                System.out.println("\tTEST FAILED");
                return;
            }
        }
        if(list2.getSize() != arr2.length){
            System.out.println("\tTEST FAILED");
            return;
        }
        System.out.println("\tTEST PASSED");

        //remove test
        System.out.println("test remove:");
        SortedIntegerList list3 = new SortedIntegerList(false);
        int tmp = rand.nextInt(40);
        int[] arr3 = new int[tmp];
        for (int i = 0; i < tmp; i++) {
            list3.add(arr[i]);
            list3.remove(arr[i]);
        }
        if(list3.getSize() == 0)
            System.out.println("\tTEST PASSED");
        else {
            System.out.println("\tTEST FAILED");
            return;
        }

        //equals test -7, -5, -1, 1, 5
        System.out.println("test equals()");
        SortedIntegerList list4 = new SortedIntegerList(false);
        SortedIntegerList list5 = new SortedIntegerList(false);
        list4.add(1).add(-7).add(5).add(-1).add(-5);
        //System.out.println(list2 + "\n" + list4);
        if(!list2.equals(list4)) {
            System.out.println("\tTEST repeat PASSED"); //потому что repeat флаг разный у них.
        }
        else {
            System.out.println("\tTEST FAILED");
            return;
        }
        list5.add(1).add(-7).add(5).add(-1).add(-5);
        //System.out.println(list4 + "\n" + list5);
        if(list4.equals(list5)) {
            System.out.println("\tTEST equal values PASSED");

        }
        else {
            System.out.println("\tTEST equal values FAILED");
            return;
        }
        list5.remove(1);
        if (!list4.equals(list5)) {
            System.out.println("\tTEST different values PASSED");
        }
        else {
            System.out.println("\tTEST different values FAILED");
            return;
        }
        System.out.println("!!!ALL TESTS HAVE BEEN PASSED!!!");
    }
}
