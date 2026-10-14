import java.util.*;

public class Main {
  public static void main(String[] args) {
    
    /*int[][] arr = {
      {1,2,3},
      {4,5,6},
      {7,8,9}
    };*/
    /*
    (0,0), (0,1)
    */
    /*int[][] arr = {
      { 1, 2, 3, 4},
      { 5, 6, 7, 8},
      { 9,10,11,12},
      {13,14,15,16}
    };/*
    (0,0), (0,1), (0,2)
           (1,1)
    */
    /*
    int[][] arr = {
      { 1, 2, 3, 4, 5},
      { 6, 7, 8, 9,10},
      {11,12,13,14,15},
      {16,17,18,19,20},
      {21,22,23,24,25}
    };//*/
    /*5
      (0,0), (0,1), (0,2), (0,3)
             (1,1), (1,2)
    */
    int[][] arr = {
        { 1,  2,  3,  4,  5,  6},
        { 7,  8,  9, 10, 11, 12},
        {13, 14, 15, 16, 17, 18},
        {19, 20, 21, 22, 23, 24},
        {25, 26, 27, 28, 29, 30},
        {31, 32, 33, 34, 35, 36}
    };//*/
    /*6
      (0,0), (0,1), (0,2), (0,3), (0,4)
             (1,1), (1,2), (1,3)
                    (2,2)
    */
    int arrSize = arr.length-1;
    for (int right = 0; right <= arrSize/2; right++) {
      for (int top = right; top < arrSize - right; top++) {
        System.out.println("Swapping: " + right + " " + top);
        /*
          n
        w   e
          s
        ne->nw
        se->ne
        sw->se
        nw->sw
        */
        int prevNW = arr[top][right];
        int prevNE = arr[right][arrSize - top];
        int prevSE = arr[arrSize - top][arrSize - right];
        int prevSW = arr[arrSize - right][top];

        arr[top][right] = prevSW;
        arr[right][arrSize - top] = prevNW;
        arr[arrSize - top][arrSize - right] = prevNE;
        arr[arrSize - right][top] = prevSE;
      }
    }
    System.out.println("Solution: ");
    for (int[] row : arr) {
      for (int i : row) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}
