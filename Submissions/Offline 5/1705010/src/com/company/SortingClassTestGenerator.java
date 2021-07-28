package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SortingClassTestGenerator {

    static List<Integer> getBlankList()
    {
        List<Integer>list = Arrays.asList();
        return list;
    }

    static List<Integer> getOneNumber()
    {
        List<Integer>list = Arrays.asList(4);
        return list;
    }

    static List<Integer> getTwoNumber()
    {
        List<Integer>list = Arrays.asList(213,3432);
        return list;
    }

    static List<Integer> getRandomSizeList()
    {
        Random generator = new Random(1705010);
        Integer listSize = generator.nextInt() % 50;

        List<Integer>list = new ArrayList<>();

        for(int i=0;i<listSize;i++)
        {
            list.add(generator.nextInt());
        }

        return list;
    }

    static List<Integer> getRandomList()
    {
        Random generator = new Random(1705010);
        Integer listSize = 15;

        List<Integer>list = new ArrayList<>();

        for(int i=0;i<listSize;i++)
        {
            list.add(generator.nextInt());
        }

        return list;
    }

    static List<Integer> getSortedAscending()
    {
        List<Integer>list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,11,12,35,45);
        return list;
    }

    static List<Integer> getSortedDescending()
    {
        List<Integer>list = Arrays.asList(25,17,14,13,12,11,10,9,8,7,6,5,4,3,2,1);
        return list;
    }

    static List<Integer> getEqualElemenetList()
    {
        List<Integer>list = Arrays.asList(10,10,10,10,10,10,10,10,10,10);
        return list;
    }

    static List<Integer> getNegativeElementList()
    {
        List<Integer>list = Arrays.asList(-123,-23,-23,-25,-32,-74,-122,-32,-33,-56,-23);
        return list;
    }

    static List<Integer> getNull()
    {
        return null;
    }
}
