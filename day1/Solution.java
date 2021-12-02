package day1;

import java.util.List;
import static java.util.stream.Collectors.toList;

public class Solution {

  public final String PATH = "day1";

  public void first(List<String> nums) {
    var numbers = nums.stream().map(it -> Integer.parseInt(it)).collect(toList());
    System.out.println(numberOfIncreases(numbers));
  }

  public void second(List<String> nums) {
    var numbers = nums.stream().map(it -> Integer.parseInt(it)).collect(toList());
    System.out.println(numberOfWindowIncreases(numbers));
  }

  private static int numberOfIncreases(List<Integer> nums) {
    int res = 0;
    for (int i = 1; i < nums.size(); i++) {
      if (nums.get(i) - nums.get(i - 1) > 0) {
        res++;
      }
    }
    return res;
  }
    
  private static int numberOfWindowIncreases(List<Integer> nums) {
    int res = 0;
    int sum = nums.get(0) + nums.get(1) + nums.get(2);
    for (int i = 3; i < nums.size(); i++) {
      int nextSum = sum - nums.get(i - 3) + nums.get(i);
      if (nextSum - sum > 0) {
        res++;
      }
      sum = nextSum;
    }
    return res;
  }
}