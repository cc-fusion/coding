import java.util.*;

public class Main {
  public static void main(String[] args) {
    String str = "abcabcbcbb";
    HashMap<Character, Integer> map = new HashMap<>();
    int left = 0;
    int maxLength = 0;
    for (int right = 0; right < str.length(); right++) {
      while (left < right && map.containsKey(str.charAt(right))) {
        //System.out.println("> " + left + " " + right + " " + str.substring(left, right+1));
        map.remove(str.charAt(left));
        left++;
      }
      map.put(str.charAt(right), 1);
      System.out.println(left + " " + right + " " + str.substring(left, right+1));
      if (right-left+1 > maxLength) maxLength = right-left+1;
    }
    System.out.println(maxLength);
  }
}
