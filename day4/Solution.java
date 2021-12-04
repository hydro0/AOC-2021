package day4;

import java.util.*;

public class Solution {

  public final String PATH = "day4";

  private final List<Integer> numbers = new ArrayList<>();
  private final List<int[][]> boards = new ArrayList<>();
  private final Map<Integer, List<int[]>> positions = new HashMap<>();

  public void first(List<String> lines) {
    parse(lines);
    System.out.println(solve());
  }
  
  public void second(List<String> lines) {
    parse(lines);
    System.out.println(lose());
  }

  private void parse(List<String> lines) {
    numbers.clear(); boards.clear(); positions.clear();
    for (String p : lines.get(0).split(",")) {
      numbers.add(Integer.parseInt(p));
    }
    
    for (int i = 2; i < lines.size(); i += 6) {
      int[][] board = new int[5][5];
      for (int row = 0; row < 5; row++) {
        String[] parts = lines.get(i + row).trim().split(" ");
        for (int col = 0; col < 5; col++) {
          board[row][col] = Integer.parseInt(parts[col]);
        }
      }
      boards.add(board);
    }

    for (int b = 0; b < boards.size(); b++) {
      for (int row = 0; row < 5; row++) {
        for (int col = 0; col < 5; col++) {
          int num = boards.get(b)[row][col];
          positions.putIfAbsent(num, new ArrayList<>());
          positions.get(num).add(new int[] { b, row, col });
        }
      }
    }
  }

  private int solve() {
    int[][] state = new int[boards.size()][10];
    Set<Integer> seen = new HashSet<>();
    for (int n : numbers) {
      if (!seen.add(n)) continue;
      if (!positions.containsKey(n)) continue;
      for (int[] pos : positions.get(n)) {
        if (++state[pos[0]][pos[1]] == 5 || ++state[pos[0]][pos[2] + 5] == 5) {
          return sum(seen, boards.get(pos[0])) * n;
        }
      }
    }
    return -1;
  }

  private int lose() {
    int[][] state = new int[boards.size()][10];
    Set<Integer> seen = new HashSet<>();
    Set<Integer> won = new HashSet<>();
    int last = -1;
    for (int n : numbers) {
      if (!seen.add(n)) continue;
      if (!positions.containsKey(n)) continue;
      for (int[] pos : positions.get(n)) {
        if ((++state[pos[0]][pos[1]] == 5 || ++state[pos[0]][pos[2] + 5] == 5) && won.add(pos[0])) {
          last = sum(seen, boards.get(pos[0])) * n;
        }
      }
    }
    return last;
  }

  private static int sum(Set<Integer> seen, int[][] board) {
    int s = 0;
    for (int[] r : board) {
      for (int n : r) {
        if (!seen.contains(n)) s += n;
      }
    }
    return s;
  }
}