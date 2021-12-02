package day2;

import java.util.List;
import static java.util.stream.Collectors.toList;

public class Solution {

  public final String PATH = "day2";

  public void first(List<String> dirs) {
    System.out.println(position(dirs));
  }
  
  public void second(List<String> dirs) {
    System.out.println(positionAim(dirs));
  }

  private static long position(List<String> dirs) {
    long x = 0, depth = 0;
    for (String dir : dirs) {
      String[] parts = dir.split(" ");
      int change = Integer.parseInt(parts[1]);
      switch (parts[0]) {
        case "down": { depth += change; break; }
        case "up": { depth -= change; break; }
        default: { x += change; break; }
      }
    }
    return x * depth;
  }

  private static long positionAim(List<String> dirs) {
    long x = 0, aim = 0, depth = 0;
    for (String dir : dirs) {
      String[] parts = dir.split(" ");
      int change = Integer.parseInt(parts[1]);
      switch (parts[0]) {
        case "down": { aim += change; break; }
        case "up": { aim -= change; break; }
        default: { x += change; depth += aim * change; break; }
      }
    }
    return x * depth;
  }
}