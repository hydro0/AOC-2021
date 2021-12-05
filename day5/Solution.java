package day5;

import java.util.*;

public class Solution {

  public final String PATH = "day5";

  public void first(List<String> lines) {
    System.out.println(solve(lines));
  }

  public void second(List<String> lines) {
    System.out.println(solve2(lines));
  }
  
  private static int solve(List<String> lines) {
    int[][] map = new int[1000][1000];
    for (String line : lines) {
      String[] parts = line.split(" -> ");
      String[] from = parts[0].split(",");
      String[] to = parts[1].split(",");

      int[] a = new int[] { Integer.parseInt(from[0]), Integer.parseInt(from[1]) };
      int[] b = new int[] { Integer.parseInt(to[0]), Integer.parseInt(to[1]) };
      if (a[0] == b[0]) {
        for (int y = Math.min(a[1], b[1]); y <= Math.max(a[1], b[1]); y++) {
          map[a[0]][y]++;
        }
      } else if (a[1] == b[1]) {
        for (int x = Math.min(a[0], b[0]); x <= Math.max(a[0], b[0]); x++) {
          map[x][a[1]]++;
        }
      }
    }
    int t = 0;
    for (int[] r : map) {
      for (int v : r) {
        if (v > 1) t++;
      }
    }
    return t;
  }
  
  private static int solve2(List<String> lines) {
    int[][] map = new int[1000][1000];
    for (String line : lines) {
      String[] parts = line.split(" -> ");
      String[] from = parts[0].split(",");
      String[] to = parts[1].split(",");

      int[] a = new int[] { Integer.parseInt(from[0]), Integer.parseInt(from[1]) };
      int[] b = new int[] { Integer.parseInt(to[0]), Integer.parseInt(to[1]) };
      int dx = d(a[0], b[0]), dy = d(a[1], b[1]);
      if (dx == 0 && dy == 0) {
        map[a[0]][a[1]]++;
      }
      for (int x = a[0], y = a[1]; x != b[0] + dx || y != b[1] + dy; x += dx, y += dy) {
        map[x][y]++;
      }
    }
    int t = 0;
    for (int[] r : map) {
      for (int v : r) {
        if (v > 1) t++;
      }
    }
    return t;
  }

  private static int d(int a, int b) {
    return b > a ? 1 : b < a ? -1 : 0;
  }
}