# **CSE 308 `Software Engineering`**

 - ## **`Offline 1`**
  
    **Java Refresher and OOP Design Principle**
   - [Problem Statement](/Offline%201/CSE_308_OOP_Offline_1.pdf)
   - [Solution](/Offline%201/src)

 - ## **`Offline 2`**
  
    **Creational Design Pattern**
   - [Problem Statements](/Offline%202/Assignment%202%20on%20Creational%20Design%20Pattern.pdf)
   - [Problem 1 Solution](/Offline%202/Problem%201/src) : **Abstract Factory + Builder Design Pattern**

     ![](Offline%202/Problem%201/uml_class_diagram_simplified.png)

   - [Problem 2 Solution](/Offline%202/Problem%202/src) : **Singleton + Abstract Factory Design Pattern**
      
      ![](Offline%202/Problem%202/uml_class_diagam_simplified.png)

      ![](Offline%202/Problem%202/uml_class_diagam_detailed.png)

 - ## **`Offline 3`**
  
    **Structural Design Pattern**
   - [Problem Statements](Offline%203/Problems%20on%20Structural%20Design%20Patterns.pdf)
   - [Problem 1 Solution](/Offline%203/Problem%201/src) : **Adapter Design Pattern**

     ![](Offline%203/Problem%201/Problem_1.png)

   - [Problem 2 Solution](/Offline%203/Problem%202/src) : **Decorator Design Pattern**
      
     ![](Offline%203/Problem%202/Problem_2.png)


- ## **`Offline 4`**
  
    **Behavioral Design Pattern**
   - [Problem Statements](Offline%204/Jan_2021_CSE_308_Behavioural_Design_Patterns.pdf)
   - [Problem 1 Solution](Offline%204/Problem%201/src) : **Observer Design Pattern**

     ![](Offline%204/Problem%201/Offline_4__Problem_1.png)

   - [Problem 2 Solution](/Offline%204/Problem%202/src) : **Mediator Design Pattern**
      
     ![](Offline%204/Problem%202/Offline_4__Problem_2.png)

- ## **`Offline 5`**

  **Unit Testing**
  - [Problem Statement](Offline%205/Problem%20on%20Testing.pdf)
  - [Solution](Offline%205/Unit-Testing/src)
      - Parameterized Unit Testing

        ```java
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
        ``` 

        ```java
          @org.junit.Test
          public void sort() {

              List<Integer>listIn = null;

              if(inputList != null) listIn = new ArrayList<Integer>(inputList);
              List<Integer>listOut = sortingClass.sort(inputList);

              assertTrue(message +": List altered",checkNotAltered(listIn,listOut));
              assertTrue(message +": List not sorted\nOutput = "+listOut,checkSortedAscending(listOut));
          }
        ```
