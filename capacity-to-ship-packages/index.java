import java.util.*;

public class Main {
  public static void main(String[] args) {
    int[] weights = {1,2,3,4,5,6,7,8,9,10};
    System.out.println(problem(5, weights));
  }
  public static int testCapacity(int days, int[] weights, int capacity) {
    int i = 0;
    for (int j = 0; j < days; j++) {
      int sum = 0;
      while (i < weights.length) {
        sum += weights[i];
        if (sum >= capacity) break;
        i++;
      }
      if (i >= weights.length) return -1; // capacity -> lower
    }
    if (i < weights.length) {
      return 1; // capacity -> higher
    }
    return 0; // works
  }
  public static int problem(int days, int[] weights) {
    int minCap = 0;
    int maxCap = 0;
    for (int i : weights) maxCap += i;
    while (maxCap - minCap > 1) {
      int midCap = (minCap + maxCap) / 2;
      int testResult = testCapacity(days, weights, midCap);
      // System.out.println(minCap + " " + maxCap + " " + midCap + " " + testResult);
      if (testResult == -1) {
        maxCap = midCap;
      } else if (testResult == 1) {
        minCap = midCap;
      } else {
        return midCap;
      }
    }
    return (minCap + maxCap) / 2;
  }
}
