import java.util.*;

public class Main {
  public static void main(String[] args) {
    int[] nums = {3,5,1,2};
    int maxIdx = 0;
    int maxNum = nums[0];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > maxNum) {
        if (nums[i] >= maxNum * 2) {
          maxIdx = i;
        } else {
          maxIdx = -1;
        }
        maxNum = nums[i];
      }
    }
    System.out.println(maxIdx);
  }
}
