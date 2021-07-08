package com.company;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        SortingClass sortingClass = new SortingClass();

        List<Integer>list = Arrays.asList(3,1,2,3,4);

        List<Integer>sortedList = sortingClass.sort(list);

        System.out.println(list);
        System.out.println(sortedList);

    }
}
