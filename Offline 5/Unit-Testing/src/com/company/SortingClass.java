package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingClass {

    List<Integer> sort(List<Integer>list)
    {
        int n = list.size();

        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(list.get(j) > list.get(j+1)) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }

        return list;
    }
}
