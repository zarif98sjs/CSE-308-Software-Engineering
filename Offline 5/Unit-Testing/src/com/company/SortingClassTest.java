package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RunWith(Parameterized.class)
public class SortingClassTest {

    private List inputList;
    private List expectedList;
    private String message;

    private SortingClass sortingClass;
    private static SortingClassTestGenerator sortingClassTestGenerator;

    public SortingClassTest(String message,List inputList, List expectedList)
    {
        super();
        this.message = message;
        this.inputList = inputList;
        this.expectedList = expectedList;
    }

    @org.junit.Before
    public void setUp() throws Exception {
        sortingClass = new SortingClass();
    }

    @Parameterized.Parameters
    public static Collection input(){
        return Arrays.asList(new Object[][] {
                {"SortOneNumber",SortingClassTestGenerator.getOneNumber(),Arrays.asList(4)},
                {"SortTwoNumber",SortingClassTestGenerator.getTwoNumber(),Arrays.asList(21,3432)}
        });
    }

    @org.junit.Test
    public void sort() {
        assertEquals(message,expectedList,sortingClass.sort(inputList));
    }

    @org.junit.After
    public void tearDown() throws Exception {
        sortingClass = null;
        sortingClassTestGenerator = null;
    }

    boolean checkNotAltered(List listIn,List listOut)
    {
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
        int n = listOut.size();

        for(int i=1;i<n;i++)
        {
            if((Integer)listOut.get(i) < (Integer)listOut.get(i-1)) return false;
        }

        return true;
    }
}