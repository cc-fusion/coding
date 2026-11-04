import java.util.*;

public class Main {
  public static void debug(int[] heights) {
    int max = 0;
    for (int h : heights) max = max < h ? h : max;
    for (int y = max-1; y >= -1; y--) {
      for (int h : heights) {
        System.out.print((h > y ? "#" : ".") + " ");
      }
      System.out.println();
    }
  }
  public static void main(String[] args) {
    int[] heights = {0,1,0,2,1,0,1,3,3,2,1,2,1};
    debug(heights);
    int total = 0;
    int i = 0;
    int maxHeightIndex = 0;
    while (i < heights.length) {
      System.out.println("i=" + i + ",total=" + total);
      if (heights[i] == 0) {
        if (heights[i] > heights[maxHeightIndex]) maxHeightIndex = i;
        i++;
        continue;
      }
      int partialTotal = 0;
      int j = i+1;
      while (j < heights.length && heights[j] < heights[i]) {
        if (heights[j] > heights[maxHeightIndex]) maxHeightIndex = j;
        partialTotal += heights[i] - heights[j];
        System.out.println("j=" + j + ",partial total=" + partialTotal);
        j++;
      }
      if (j < heights.length && heights[j] > heights[maxHeightIndex]) maxHeightIndex = j;
      if (j >= heights.length) break;
      total += partialTotal;
      i = j;
    }
    i = heights.length - 1;
    while (i >= maxHeightIndex) {
      System.out.println("i=" + i + ",total=" + total);
      if (heights[i] == 0) {
        i--;
        continue;
      }
      int partialTotal = 0;
      int j = i-1;
      while (j >= maxHeightIndex && heights[j] < heights[i]) {
        partialTotal += heights[i] - heights[j];
        System.out.println("j=" + j + ",partial total=" + partialTotal);
        j--;
      }
      total += partialTotal;
      i = j;
    }
    System.out.println(total);
  }
}
