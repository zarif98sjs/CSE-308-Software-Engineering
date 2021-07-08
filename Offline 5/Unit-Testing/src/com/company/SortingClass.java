package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingClass {

    List<Integer> sort(List<Integer>list)
    {
        int n = list.size();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(list.get(i) > list.get(i+1)) {
                    Collections.swap(list, i, i + 1);
                }
            }
        }

        return list;
    }
}
