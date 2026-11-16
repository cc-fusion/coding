import java.util.*;

public class Main {
  public class Pair {
    int first;
    int second;
    Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }
  public static void main(String[] args) {
    int[] temps = {73,74,75,71,69,72};
    int[] days = new int[temps.length];
    
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < temps.length-1; i++) {
      stack.push(i);
      if (temps[i] < temps[i+1]) {
        while (!stack.isEmpty()) {
          int val = stack.peek();
          if (temps[i+1] > temps[val]) {
            days[val] += i-val+1;
            stack.pop();
          } else {
            break;
          }
        }
      }
    }
    for (int i = 0; i < days.length; i++) {
      if (days[i] == 0) days[i] = -1;
    }
    for (int day : days) System.out.print(day + " "); System.out.println();
  }
}
