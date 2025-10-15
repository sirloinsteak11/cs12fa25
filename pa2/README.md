
# CSE 12 PA2: Generics & ArrayLists

**Due Date: Thursday, October 16, 2025, 11:59pm PST**

There is an FAQ post on Piazza. Please read that post first if you have any questions.


### **Learning goals:**
* Implement a data structure similar to Java’s ArrayLists with generic types
* Write JUnit tests to verify proper implementation
* Use Big-O notation to explain the runtime of algorithms

**Note:** We expect students to adhere to the academic integrity policy in all programming assignments. We reserve the right to interview any students suspected of violating the academic integrity policy.

You will find the following files:

```
+-- starter
|   +-- MyList.java
|   +-- RuntimeTester.java
|   +-- MyArrayListPublicTester.java
|   +-- MyArrayListHiddenTester.java              Edit this file
|   +-- MyArrayList.java (create this file)       Edit this file
```

## **Task 1: Testing and Implementation of ArrayList [95 points]**

In this part of the assignment, you will implement a data structure similar to Java's ArrayList and write JUnit tests to ensure that your implementation functions correctly.

**Make sure to read the entire write-up before you start coding.**

Download the starter code and put it in a directory in your working environment.

#### How to run and compile the testers:
Running the tester on UNIX based systems (including a mac):

* Compile: `javac -cp ../libs/junit-4.13.2.jar:../libs/hamcrest-2.2.jar:. MyArrayListPublicTester.java`
* Execute: `java -cp ../libs/junit-4.13.2.jar:../libs/hamcrest-2.2.jar:. org.junit.runner.JUnitCore MyArrayListPublicTester`

Running the tester on Windows systems:

* Compile: `javac -cp ".;..\libs\junit-4.13.2.jar;..\libs\hamcrest-2.2.jar" MyArrayListPublicTester.java`
* Execute: `java -cp ".;..\libs\junit-4.13.2.jar;..\libs\hamcrest-2.2.jar" org.junit.runner.JUnitCore MyArrayListPublicTester`

To run the hidden tester, replace references to `MyArrayListPublicTester` with `MyArrayListHiddenTester` in the above commands.

### Part 1: JUnit Testing (20 points)

We provide two test files:

* `MyArrayListPublicTester.java`
    * Contains all the public test cases we will use to grade your MyArrayList implementation (visible on Gradescope)
* `MyArrayListHiddenTester.java`
    * Contains only the headers and description to the hidden test cases we will use to grade your MyArrayList implementation (hidden until the PA is graded) 

**Your task:** Implement the missing unit tests in MyArrayListHiddenTester.java based on the description in ‘hidden tests’ column in the Tests table below.



* Your tests will be graded to check if they pass/ fail correctly
* **NOTE:** DO NOT CHANGE THE TEST HEADERS!

**Tests Table: List of various test cases and their description**
<table>
  <tr>
   <td><strong>Test Cases</strong>
   </td>
   <td><strong>Public Tests</strong>
   </td>
   <td><strong>Hidden Tests (Implement these)</strong>
   </td>
  </tr>
  <tr>
   <td><code>Constructors</code>
   </td>
      
   <td>MyArrayList objects instantiated with the three different constructors should have the correct properties specified. If the argument passed into the constructor is invalid, throw the correct exception.
<ul>

<li>No-arg constructor is instantiated with correct capacity

<li>Constructor that takes in a positive capacity 

<li>Constructor that takes in a valid array
</li>
</ul>
   </td>
   <td>
<ul>
<!--  below are JUnit Constructors    -->
<li>Invalid input for capacity arg constructor

<li>Null input for array arg constructor
</li>
<!--  below are testHidden Constructors    -->
<li>All elements in array is valid (even the nulls) with correct size
</li>
</ul>
   </td>
  </tr>
  <tr>
   <td><code>append</code>
   </td>
   <td>Test if an element is correctly inserted at the end of the ArrayList, while preserving existing elements. Size and capacity should be updated to reflect the change to the ArrayList where applicable.
<ul>

<li>Append to an empty MyArrayList

<li>Append to a non-empty MyArrayList
</li>
</ul>
   </td>
   <td>
<ul>
<li>Append when MyArrayList is at capacity
</li>
<li>Append null
</li>
</ul>
   </td>
  </tr>
  <tr>
   <td><code>prepend</code>
   </td>
   <td>Test if an element is correctly inserted at the beginning of the ArrayList, while preserving existing elements. Size and capacity should be updated to reflect the change to the ArrayList where applicable.
<ul>

<li>Prepend to an empty MyArrayList

<li>Prepend to a non-empty MyArrayList
</li>
</ul>
   </td>
   <td>
<ul>

<li>Prepend when MyArrayList is at capacity
</li>
<li>Prepend null
</li>
</ul>
   </td>
  </tr>
  <tr>
   <td><code>insert</code>
   </td>
   <td>Test if an element is inserted at the correct location and if size and capacity are updated appropriately to account for the newly inserted element.
<ul>

<li>Insert at index in the range [0, size]
</li>
</ul>
   </td>
   <td>
<ul>
<!--  below are JUnit Insert (UNCHANGED)    -->
<li>Insert at out-of-bounds index
<li>Insert multiple times
</li>
<!--  below are testHidden  Insert  (empty rn!) -->
</ul>
   </td>
  </tr>
  <tr>
   <td><code>get</code>
   </td>
   <td>Test if the value returned is correct. Size and capacity should remain unchanged.
<ul>
<!--  below are JUnit get    -->
<li>Get an element at index in the range [0, size - 1]
</li>
</ul>
   </td>
   <td>
<ul>

<li>Get an element at an out-of-bounds index
</li>
<!--  below are testHidden  get  (too descriptive?) -->
</li>
</ul>
   </td>
  </tr>
  <tr>
   <td><code>set</code>
   </td>
<!--  below are JUnit  set   -->
   <td>Test if the element is changed correctly. Size and capacity should remain unchanged.
<ul>

<li>Set an element at index in the range [0, size - 1]
</li>
</ul>
   </td>
   <td>
<ul>

<li>Set an element at an out-of-bounds index
</li>

</ul>
   </td>
  </tr>
  <tr>
   <td><code>remove</code>
   </td>
   <td>Test if the correct element is removed. Capacity remains unchanged.
<ul>

<li>Remove an element at index in the range [0, size - 1]
</li>
</ul>
   </td>
   <td>
<ul>
<!--  below are JUnit Remove    -->
<li>Remove an element from an out-of-bounds index
</li>
<li>Remove multiple elements from a list</li>
<!--  below are TestHidden Remove  (empty rn!) -->
</ul>
   </td>
  </tr>
  <tr>
   <td><code>size</code>
   </td>
   <td>Test if the correct size is returned. The ArrayList should remain unchanged after call to <code>size()</code>.
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td><code>expandCapacity</code>
   </td>
   <td>Test if capacity is expanded appropriately.
<ul>

<li>If the data array is not large enough, capacity is updated correctly by doubling the capacity
</li>
<li>If capacity is 0, it should be reset to the default of 5
</li>
</ul>
   </td>
   <td>
<ul>
<!--  below are JUnit expandCapacity    -->

<li>If required capacity is smaller than the current capacity,  <code>IllegalArgumentException</code>is thrown 
</li>
<li>If the capacity is not large enough after doubling or setting to the default capacity, capacity is updated correctly to the required capacity
</li>

</ul>
   </td>
  </tr>
  <tr>
   <td><code>getCapacity</code>
   </td>
   <td>Test that the correct capacity size is being returned for an empty and populated <code>ArrayList</code>. The <code>ArrayList</code> should remain unchanged after the call to <code>getCapacity()</code>.
<ul>

<li>Correctly return capacity for different constructors
</li>
</ul>
   </td>
   <td>
   </td>
  </tr>
<tr>
   <td>
      <code>rotate</code>
   </td>
   <td>
      Test if the list is rotated correctly. Size and capacity should remain unchanged.
      <ul>
         <li>
            Rotate right the ArrayList by numPositions in the range [0, size - 1]
         </li>
      </ul>
   </td>
   <td>
      <ul>
         <li>
            Rotate right the ArrayList by an out-of-bounds value for numPositions
         </li>
      </ul>
   </td>
</tr>
<tr>
   <td>
      <code>find</code>
   </td>
   <td>
      Test if the index returned is correct. Size and capacity should remain unchanged.
      <ul>
         <li>
            Find an element that exists in the list with index in the range [0, size - 1].
         </li>
      </ul>
   </td>
   <td>
      <ul>
         <li>
            Find an element that exists multiple times in the list.
         </li>
         <li>
            Find an element that does not exist in the list.
         </li>
      </ul>
   </td>
</tr>
</table>






### Part 2: Implementation of ArrayList (70 points)

In this part of the assignment, you will create your own implementation of ArrayList called MyArrayList.


#### **Important Note**

**DO NOT IMPORT AND USE JAVA'S BUILT IN ARRAYLIST or any other imports!!!** If we see that you do use these functions, you will receive a zero. You must implement the ArrayList from scratch to earn credit for this assignment.



* Edit the file named MyArrayList.java. Make sure the MyArrayList class implements MyList. MyArrayList is a generic class. This class will only be a subset of the Java Collection’s Framework ArrayList. 
* **Your task is to implement the instance variables, constructors and public methods stubbed out in the interface and described in the table below.**
* There are various ways to implement an ArrayList. In PA2, you will follow these:


#### **Instance Variables**

**Do not make these instance variables private**, they should have the default access modifier (i.e. do not declare them as public or private). Do not add any other instance variables and static variables other than private static final variables to be used as constants. There are **two** instance variables. 



* `Object[] data`: 

    The underlying data structure of the ArrayList. The index of an element in this array should correspond to the index of the element in the ArrayList.

    * You don't need to check if `data` is `null` in any of your code. You can assume `data` will never be `null`.
    * `null` can be a valid element in your ArrayList. The only way of knowing if an element is valid or not is by checking the `size` variable, defined below. All invalid elements in the array should be `null`. Check the [Example with nulls](#example-using-append-and-remove-on-list-with-nulls) for more clarity.
    * In some of the methods you will write, you will need to return an object of type `E`, but our `data` array is of type `Object`, so we will need to cast whatever we return to type `E` (e.g., `(E) data[0]`). If you compile with code that does this, you will see the following _warning_.


![](https://i.imgur.com/7bylVPS.png)

The code will still work exactly the same, but if you want to hide this warning, add `@SuppressWarnings("unchecked")` above any method that does this cast


![](https://i.imgur.com/HGR5H7D.png)

* `int size`: \
This variable should be equal to the number of valid elements in your `data` array. A valid element in `data` is an element in your ArrayList.
    * You may assume that nothing (other than possibly your own code) would change `size` to be something out of bounds of `data` (i.e., `size >= 0 && size <= data.length` will always evaluate to `true`, unless your code manually sets it to be something else).


#### **Constructors**

There are **three** constructors. 



* `public MyArrayList()`: \
Initialize the Object array with the default length of 5. The capacity of the ArrayList is the length of the array. 
    * **the capacity (length of `data`: `data.length`) is ==not== the same as the size (number of elements in the ArrayList, i.e., the number of *valid* elements in the array)**
* `public MyArrayList(int initialCapacity)`:
Initialize the Object array with the length of `initialCapacity`. If the `initialCapacity` is invalid (i.e. any value of `initialCapacity` strictly less than 0), throw an `IllegalArgumentException`.
* `public MyArrayList (E[] arr)`: \
Initialize the instance variables with a copy of the input array of capacity equal to the length of `arr`. All elements in `arr` are valid (even the `null`s), so set `size` accordingly. If `arr` is `null`, fall back to the behavior of the no-arg constructor (construct an ArrayList with the default capacity).


#### **Public Methods**

**Do not make these functions private**, they should all remain public (for testing and grading purposes). There are **eleven** methods. 

The following table includes all the methods you need to implement in MyArrayList.java


|Method Name|Description|Example|Exceptions to Throw|
|--- |--- |--- |--- |
|`public void expandCapacity (int requiredCapacity)`|If the current capacity is non-zero, double the current capacity. If the current capacity is 0, reset the capacity to the default capacity of 5. If the capacity is still not enough, then set the capacity to requiredCapacity. This method should preserve the current size and elements in the list (the elements before and after expansion should be at the same indices respectively).|If the current capacity is 3 and requiredCapacity is 4, the capacity afterward should be 6. If the current capacity is 3 and requiredCapacity is 18, then capacity should be set to 18 (because $2*3=6$ is less than 18). If the current capacity is 0 and requiredCapacity is 11, then the capacity should be set to 11 (the capacity gets reset to 5, which is less than 11, so it is set to 11).|Throw an `IllegalArgumentException` when `requiredCapacity` is *strictly less than* the current capacity.|
|`public int getCapacity()`|Get the number of elements that the underlying array can possibly hold, i.e. the length of the underlying array.|None.|None.|
|`public void insert(int index, E element)`|Insert an element at the specified index. If the array is at capacity before insertion, update the capacity according to `expandCapacity()`'s rules. You may want to take a look at the `expandCapacity()` method.|If the list is`{1,2,3}` and you insert 4 at index 2, the resulting list will be `{1,2,4,3}`. If the list is initially empty {}, and you insert 4 at index 0, the resulting list will be `{4}`. | Throw an `IndexOutOfBoundsException` when the index is *strictly less than 0* or *strictly greater than* the size of the ArrayList.|Throw an `IndexOutOfBoundsException` when the index is *strictly less than 0* or *strictly greater than* the size of the ArrayList.|
|`public void append(E element)`|Add an element at the end of the list. If the array is at full capacity, update the capacity according to `expandCapacity()`'s rules.| If the list is `{1,2,3}` and you append 4, the resulting list will be `{1,2,3,4}`. If the list is empty and you append 4, the resulting list should be `{4}` |None. |  If the list is empty and you append 4, the resulting list should be {4}.|None.|
|`public void prepend(E element)`|Add an element at the beginning of the list. If the array is at capacity, update the capacity according to `expandCapacity()`'s rules.|If the list is `{1,2,3}` and you prepend 4, the resulting list will be `{4,1,2,3}`. If the list is empty and you prepend 4, the resulting list should be `{4}`.|None.|
|`public E get(int index)`|Get an element at the specified index.|If the list is `{1,2,3}`, getting elements at index 2 should return 3.|Throw an `IndexOutOfBoundsException` when the index is *strictly less than 0* or *greater than or equal to* the size of the `ArrayList`.|
|`public E set(int index, E element)`|Set the given element at the specified index and return the overwritten element.|If the list is `{1,2,3}` and you set element at index 1 to be 4, the resulting list will be `{1,4,3}`.|Throw an `IndexOutOfBoundsException` when the index is *strictly less than 0* or *greater than or equal to* the size of the `ArrayList`.|
|`public E remove(int index)`|Remove and return the element at the specified index.|If the list is `{1,2,3}` and you remove element at index 1, the resulting list will be `{1,3}`.|Throw an `IndexOutOfBoundsException` when the index is *strictly less than 0* or *greater than or equal to* size of the `ArrayList`.|
|`public int size()`|Return the number of elements that exist in the `ArrayList`|None.|None.|
|`public void rotate(int numPositions)`|Rotates each element in the `ArrayList` right by `numPositions` amount. The element previously at the first position (index 0) in the list should be at index `numPositions` in the list after this operation.|If the list is `{1,2,3,4}` and you rotate right by 3, the resulting list will be `{2,3,4,1}`.|Throw an `IndexOutOfBoundsException` when `numPositions` is *strictly less than 0* or *greater than or equal to* the size of the `ArrayList`.|
|`public int find(E element)`|Find the given element in the `ArrayList` and return it's index. If there are multiple occurrences of the element, return the index of the **last** occurrence of that element. If the element is not in the `ArrayList`, return -1|If the list is `{1, 2, 3, 2}`, find(1) should return 0, find(3) should return 2, find(2) should return 3, and find(4) should return -1.|None.

**Note:** You may find private helper methods to be useful for delegating some of the work of these functions. Helper methods are not required but you are free to use them as you like.

Please make sure any **helper methods have the private (not public) access modifier** as our autograder tests for the correct number and names of the public methods described above.

#### **Example using `append` and `remove` on list with nulls**

As stated earlier, `null` can be a valid element in your ArrayList. In this example, bolded elements are elements in the ArrayList (valid elements of `data`) and non-bolded `null` represent unoccupied spots in `data`.

Statements on the left-hand side of the array should evaluate to expressions on the right-hand side.


<pre>
...
list.data -> [<b>3</b>, <b>1</b>, <b>null</b>, <b>5</b>, <b>null</b>, null, null] // capacity is 7
list.size() -> 5 
list.append(20);
list.size() -> 6
list.data -> [<b>3</b>, <b>1</b>, <b>null</b>, <b>5</b>, <b>null</b>, <b>20</b>, null] 
list.append(null);
list.size() -> 7
list.data -> [<b>3</b>, <b>1</b>, <b>null</b>, <b>5</b>, <b>null</b>, <b>20</b>, <b>null</b>] // capacity is still 7
list.remove(6) -> null
list.size() -> 6
list.data -> [<b>3</b>, <b>1</b>, <b>null</b>, <b>5</b>, <b>null</b>, <b>20</b>, null]
list.remove(5) -> 20
list.size() -> 5
list.data -> [<b>3</b>, <b>1</b>, <b>null</b>, <b>5</b>, <b>null</b>, null, null]
list.remove(4) -> null
list.size() -> 4
list.data -> [<b>3</b>, <b>1</b>, <b>null</b>, <b>5</b>, null, null, null]
list.remove(3) -> 5
list.size() -> 3
list.data -> [<b>3</b>, <b>1</b>, <b>null</b>, null, null, null, null]
list.remove(2) -> null
list.size() -> 2
list.data -> [<b>3</b>, <b>1</b>, null, null, null, null, null]
list.remove(1) -> 1
list.size() -> 1
list.data -> [<b>3</b>, null, null, null, null, null, null]
list.remove(0) -> 3
list.size() -> 0
list.data -> [null, null, null, null, null, null, null] 
</pre>

#### **Example using `rotate` on list with nulls**
<pre>
...
list.data -> [<b>null</b>, <b>1</b>, <b>null</b>, <b>null</b>, <b>2</b>, <b>3</b>, null, null] // capacity is 8
list.size() -> 6
list.rotate(1)
list.data -> [<b>3</b>, <b>null</b>, <b>1</b>, <b>null</b>, <b>null</b>, <b>2</b>, null, null]
list.rotate(2)
list.data -> [<b>null</b>, <b>2</b>, <b>3</b>, <b>null</b>, <b>1</b>, <b>null</b>, null, null]
</pre>

### **Part 3: Coding Style (5 points)**

Coding style is an important part of ensuring readability and maintainability of your code. We will grade your code style in all submitted code files according to the style guidelines. Namely, there are a few things you must have in each file/class/method:

* File header
* Class header
* Method header(s)
* Inline comments
* Proper indentation
* Descriptive variable names
* No magic numbers (Exception: Magic numbers can be used for testing.)
* Reasonably short methods (if you have implemented each method according to the specification in this write-up, you’re fine). This is not enforced as strictly.
* Lines shorter than 80 characters
* Javadoc conventions (`@param`, `@return` tags, `/** comments */`, etc.)


A full style guide can be found [here](https://github.com/CaoAssignments/style-guide/blob/main/README.md) and a sample styled file can be found [here](https://github.com/CaoAssignments/guides/blob/main/resources/SampleFile.java). If you need any clarifications, feel free to ask on Piazza.


## **Task 2: Runtime [5 points]**

A core goal of this course is to teach students how to identify the time complexity (Big-O notation) of an algorithm. In practice, you can use this to understand how the runtime of a algorithm will grow with larger and larger inputs. In this section, you will test your understanding on ArrayList's `prepend` and `append` methods. For this purpose, we have provided the following file:
* `RuntimeTester.java`
    * Provides functionality to test the runtime of the `prepend` and `append` methods.
    * **Note:** Do not make any modifications to this file.

You may assume that `prepend` and `append` are the same as covered in the lectures and ZyBooks.

Running the tester:
```
javac RuntimeTester.java
java RuntimeTester
```

**Your task:** Fill out **PA2 Task 2: Runtime** form on Gradescope using the results you get from running `RuntimeTester.java`. This will **NOT** be eligible for *resubmission*.

## **Submission Instructions:**

Please follow ALL of the instructions below to completely submit your assignment.



* Submit all of the following files to Gradescope. 
    * MyArrayListHiddenTester.java
    * MyArrayList.java
* Coding Style (5 points)
* Correctness (90 points) You will earn points based on the autograder tests that your code passes. If the autograder tests are not able to run (e.g., your code does not compile or it does not match the specifications in this writeup), you may not earn credit.
    * Tester (20 points)
        * The autograder will test your implementation of the Junit tests. Your unit tests are expected to fail or pass based on the `test cases` table’s `hidden tests` column in Part 1.
    * MyArrayList (70 points)
        * The autograder will test your implementation of MyArrayList on both public and hidden test cases listed in the table
* Runtime (5 points)
    * Fill out **PA2 Task 2: Runtime** on Gradescope.
