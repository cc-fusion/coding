import java.util.*;

public class Main {
  /*public static int rot(int[][] field, int x, int y, Set<Integer> visited, int iterations) {
    if (x < 0 || x >= field[0].length || y < 0 || y >= field.length) return iterations-1;
    
    if (field[y][x] == 0) return iterations - 1;

    int positionHash = x + field.length * y;
    if (visited.contains(positionHash)) return iterations-1;
    visited.add(positionHash);

    int top = rot(field, x, y-1, visited, iterations + 1);
    int bottom = rot(field, x, y+1, visited, iterations + 1);
    int left = rot(field, x-1, y, visited, iterations + 1);
    int right = rot(field, x+1, y, visited, iterations + 1);
    
    if (top > iterations) iterations = top;
    if (bottom > iterations) iterations = bottom;
    if (left > iterations) iterations = left;
    if (right > iterations) iterations = right;
    return iterations;
  }*/
  static class Point {
    int x;
    int y;
    int iterations;
    public Point(int x, int y, int iterations) {
      this.x = x;
      this.y = y;
      this.iterations = iterations;
    }
  }
  public static int problem(int[][] field) {
    int fieldHeight = field.length;
    int fieldWidth = field[0].length;
    Set<Integer> visited = new HashSet<>();
    int totalOrangeCount = 0;
    ArrayList<Point> toExplore = new ArrayList<>();
    for (int y = 0; y < fieldHeight; y++) {
      for (int x = 0; x < fieldWidth; x++) {
        int value = field[y][x];
        if (value != 0) totalOrangeCount++;
        if (value == 2) {
          toExplore.add(new Point(x, y, 1));
        }
      }
    }
    int maxRotTime = 1;
    while (toExplore.size() > 0) {
      Point currentPoint = toExplore.get(0);
      toExplore.remove(0);

      int x = currentPoint.x;
      int y = currentPoint.y;
      if (field[y][x] == 0) continue;
      int iterations = currentPoint.iterations;

      int pointHash = y + fieldHeight * x;
      if (visited.contains(pointHash)) continue;
      visited.add(pointHash);
      totalOrangeCount--;

      if (iterations > maxRotTime) maxRotTime = iterations;

      if (x - 1 >= 0) {
        toExplore.add(new Point(x-1, y, iterations + 1));
      }
      if (y - 1 >= 0) {
        toExplore.add(new Point(x, y-1, iterations + 1));
      }
      if (x + 1 < fieldWidth) {
        toExplore.add(new Point(x+1, y, iterations + 1));
      }
      if (y + 1 < fieldHeight) {
        toExplore.add(new Point(x, y+1, iterations + 1));
      }
    }

    if (totalOrangeCount == 0) {
      return maxRotTime;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[][] field = {
      {2,1,1,0},
      {0,1,1,0},
      {0,0,1,0},
      {0,0,1,1},
      {0,0,0,1}
    };
    System.out.println(problem(field));
  }
}
