import java.util.*;
public class Main {
  public static class Point {
    int x;
    int y;
    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
  public static void main(String[] args) {
    String[] grid = new String[] {
      "1,0,0,1,0", 
      "0,0,0,0,0", 
      "0,1,0,0,1", 
      "0,0,0,0,1"
    };

    System.out.println(countIslands(grid));
  }
  public static boolean arrContainsPt(ArrayList<Point> arr, int i, int j) {
    for (Point pt : arr) {
      if (pt.x == i && pt.y == j) return true;
    }
    return false;
  }
  public static ArrayList<Point> countIslandsHelper(ArrayList<Point> explored, String[] input, int i, int j) {
    explored.add(new Point(i, j));
    if (arrContainsPt(explored, i, j)) return explored;
    boolean top = i >= 1 && input[i-1].charAt(j) == '1';
    boolean bottom = i < input.length - 1 && input[i+1].charAt(j) == '1';
    boolean left = j >= 1 && input[i].charAt(j-1) == '1';
    boolean right = j < input[i].length() - 1 && input[i].charAt(j+1) == '1';

    if (top) explored = countIslandsHelper(explored, input, i-1, j);
    if (bottom) explored = countIslandsHelper(explored, input, i+1, j);
    if (left) explored = countIslandsHelper(explored, input, i, j+1);
    if (right) explored = countIslandsHelper(explored, input, i, j-1);

    return explored;
  }
  public static int countIslands(String[] input) {
    ArrayList<Point> explored = new ArrayList<>();
    int islandsCount = 0;
    for (int y = 0; y < input.length; y++) {
      for (int x = 0; x < input[y].length(); x++) {
        boolean isLand = input[y].charAt(x) == '1';
        if (isLand && !arrContainsPt(explored, x, y)) {
          islandsCount++;
          explored = countIslandsHelper(explored, input, x, y);
        }
      }
    }
    return islandsCount;
  }
}
