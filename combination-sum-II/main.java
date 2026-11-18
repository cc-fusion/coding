import java.util.*;

public class Main {
  public static ArrayList<ArrayList<Integer>> findAllCombinations(ArrayList<Integer> arr, boolean[] mask, int target, int currentTotal) {
    ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
    int i = mask.length-1;
    while (i > 0 && !mask[i]) i--;
    while (i < mask.length) {
      if (!mask[i]) {
        mask[i] = true;
        ArrayList<ArrayList<Integer>> localCombinations = findAllCombinations(arr, mask, target, currentTotal + arr.get(i));
        mask[i] = false;
        for (ArrayList<Integer> combination : localCombinations) {
          combinations.add(combination);
        }
      }
      i++;
    }
    if (target == currentTotal) {
      ArrayList<Integer> combination = new ArrayList<Integer>();
      for (int j = 0; j < mask.length; j++) {
        if (mask[j]) {
          combination.add(arr.get(j));
        }
      }
      combinations.add(combination);
    }
    return combinations;
  }
  public static void main(String[] args) {
    int[] arr1 = {1,2,3,9,16,5,4,7,8};
    ArrayList<Integer> arr = new ArrayList<Integer>();
    for (int i : arr1) arr.add(i);
    int target = 9;
    boolean[] emptyMask = new boolean[arr1.length];
    ArrayList<ArrayList<Integer>> combinations = findAllCombinations(arr, emptyMask, target, 0);
    for (ArrayList<Integer> combination : combinations) {
      for (int i : combination) {
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
}
