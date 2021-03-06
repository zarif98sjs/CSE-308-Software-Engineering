package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;

@RunWith(Parameterized.class)
public class SortingClassTest {

    private List inputList;
    private String message;

    private SortingClass sortingClass;

    public SortingClassTest(String message,List inputList)
    {
        super();
        this.message = message;
        this.inputList = inputList;
    }

    @org.junit.Before
    public void setUp() throws Exception {
        sortingClass = new SortingClass();
    }

    @Parameterized.Parameters
    public static Collection input(){
        return Arrays.asList(new Object[][] {
                {"Sort Blank List",SortingClassTestGenerator.getBlankList()},
                {"Sort One Number",SortingClassTestGenerator.getOneNumber()},
                {"Sort Two Number",SortingClassTestGenerator.getTwoNumber()},
                {"Sort Random Sized List",SortingClassTestGenerator.getRandomSizeList()},
                {"Sort Random List",SortingClassTestGenerator.getRandomList()},
                {"Sort Ascending List",SortingClassTestGenerator.getSortedAscending()},
                {"Sort Descending List",SortingClassTestGenerator.getSortedDescending()},
                {"Sort Equal Element List",SortingClassTestGenerator.getEqualElemenetList()},
                {"Sort Negative Element List",SortingClassTestGenerator.getNegativeElementList()},
                {"Sort Null List",SortingClassTestGenerator.getNull()},
        });
    }

    @org.junit.Test
    public void sort() {

        List<Integer>listIn = null;

        if(inputList != null) listIn = new ArrayList<Integer>(inputList);
        List<Integer>listOut = sortingClass.sort(inputList);

        assertTrue(message +": List altered",checkNotAltered(listIn,listOut));
        assertTrue(message +": List not sorted\nOutput = "+listOut,checkSortedAscending(listOut));
    }

    @org.junit.After
    public void tearDown() throws Exception {
        sortingClass = null;
    }
    // 2 2 3 4
    // 3 4 2 2

    boolean checkNotAltered(List listIn,List listOut)
    {
        if(listIn == null && listOut == null) return true;
        if(listIn == null || listOut == null) return false;

        if(listIn.size() != listOut.size()) return false;

        int n = listIn.size();

        for(int i=0;i<n;i++)
        {
            int num = (Integer) listIn.get(i);

            int countIn = 0 , countOut = 0;

            for(int j=0;j<n;j++) if(num == (Integer) listIn.get(j)) countIn++;

            for(int k=0;k<n;k++) if(num == (Integer) listOut.get(k)) countOut++;

            if(countIn != countOut) return false;

        }

        return true;
    }

    boolean checkSortedAscending(List listOut)
    {
        if(listOut == null) return true;

        int n = listOut.size();

        for(int i=1;i<n;i++)
        {
            if((Integer)listOut.get(i) < (Integer)listOut.get(i-1)) return false;
        }

        return true;
    }
}