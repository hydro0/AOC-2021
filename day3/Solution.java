package day3;

import java.util.*;

public class Solution {

  public final String PATH = "day3";

  public void first(List<String> lines) {
    System.out.println(power(lines));
  }
  
  public void second(List<String> lines) {
    System.out.println(lifeSupport(lines));
  }

  private static long power(List<String> lines) {
    int[] bits = new int[12];
    int total = lines.size();
    for (String line : lines) {
      char[] l = line.toCharArray();
      for (int i = 0; i < 12; i++) {
        bits[i] += (l[i] - '0');
      }
    }

    int gamma = 0;
    for (int i = 0; i < 12; i++) {
      gamma = gamma << 1;
      if (bits[i] > total / 2) {
        gamma++;
      }
    }
    int epsylon = 0b111111111111 ^ gamma;
    return epsylon * gamma;
  }

  private static long lifeSupport(List<String> lines) {
    
    String ox = find(lines, true), co2 = find(lines, false);

    int iox = 0, ico2 = 0;
    for (char c : ox.toCharArray()) {
      iox <<= 1;
      iox += (c - '0');
    }
    
    for (char c : co2.toCharArray()) {
      ico2 <<= 1;
      ico2 += (c - '0');
    }
    
    return ico2 * iox;
  }

  private static String find(List<String> lines, boolean eq) {
    for (int bit = 0; bit < 12; bit++) {
      String gamma = buildGamma(lines);
      List<String> left = new ArrayList<>();
      for (String line : lines) {
        if ((line.charAt(bit) == gamma.charAt(bit)) == eq) {
          left.add(line);
        }
      }
      if (left.size() == 0) {
        return lines.get(lines.size() - 1);
      }
      if (left.size() == 1) {
        return left.get(0);
      }
      lines = left;
    }
    throw new RuntimeException("Impossible!");
  }

  private static String buildGamma(List<String> lines) {
    int[] bits = new int[12];
    int total = lines.size();
    
    for (String line : lines) {
      char[] l = line.toCharArray();
      for (int i = 0; i < 12; i++) {
        bits[i] += (l[i] - '0');
      }
    }

    String gamma = "";
    for (int i = 0; i < 12; i++) {
      if (bits[i] * 2 >= total) {
        gamma += "1";
      } else {
        gamma += "0";
      }
    }
    return gamma;
  }
}