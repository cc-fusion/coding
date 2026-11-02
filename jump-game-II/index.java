import java.util.*;

public class Main {
  static int debugPadLength = 0;
  public static void debug(int[] arr) {
    for (int x : arr) System.out.print((x==debugPadLength?"?":x) + " ");
    System.out.println("");
  }
  public static void main(String[] args) {
    int[] pads = {2,3,1,1,4};
    debugPadLength = pads.length;
    debug(pads);
    int[] steps = new int[pads.length];
    for (int i = 1; i < steps.length; i++) steps[i] = pads.length;

    for (int i = 0; i < pads.length; i++) {
      debug(steps);
      int padSize = pads[i];
      int currentStepLength = steps[i];
      for (int j = 1; j < padSize+1; j++) {
        if (i+j >= pads.length) break;
        int lastStepLength = steps[i+j];
        if (currentStepLength+1 < lastStepLength) {
          steps[i+j] = currentStepLength+1;
        }
      }
    }

    debug(steps);
  }
}
