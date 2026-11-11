import java.util.*;

public class Main {
  public static void getAllSmooth(int[] stocks, int left, int right) {
    int distance = right - left;
    if (distance == 0) return;
    for (int length = 0; length <= distance+1; length++) {
      for (int offset = left; offset <= right-length; offset++) {
        for (int i = offset; i < offset+length+1; i++) {
          System.out.print(stocks[i] + ",");
        }
        System.out.println();
      }
    }
    System.out.println();
  }
  public static void main(String[] args) {
    int[] stocks = {3,2,1,5,6,7};
    int left = 0;
    for (int right = 1; right < stocks.length; right++) {
      //System.out.println("> " + left + ", " + right);
      if (stocks[right-1] - 1 != stocks[right]) {
        getAllSmooth(stocks, left, right-1);
        left = right;
      }
    }
    if (stocks[stocks.length-2] - 1 == stocks[stocks.length-1]) {
      getAllSmooth(stocks, left, stocks.length-1);
    }
  }
}
