/*
Thanks for using Replit for Advent of Code!

Here are a few tips:

1. To install packages, just import them and Replit will install them for you, or click on the cube in the sidebar to install manually.
2. If you're stuck, try using the debugger in the sidebar shaped like a play/pause button.
3. When you're done, you can share your project by clicking the project name and then "Publish"
3.a When you share your project, use the #adventofcode hashtag!
4. Have fun, and good luck!
*/
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import static java.util.stream.Collectors.toList;

class Main {
  public static void main(String[] args) {
    /*
    Place your question data into the data.txt file.
    You may need to parse the data!
    */
    Path filePath = Paths.get("data.txt");
    Charset charset = StandardCharsets.UTF_8;
    List<String> dataLines;
    try {
      dataLines = Files.readAllLines(filePath, charset);
      var numbers = dataLines.stream().map(it -> Integer.parseInt(it)).collect(toList());
      System.out.println(solve(numbers));
    } catch (IOException ex) {
            System.out.format("I/O error: %s%n", ex);
    }
    long start = System.nanoTime();



    // Keep this line at the end of your code
    long end = System.nanoTime();
    long elapsedTime = end - start;
    System.out.format("Elapsed time: %dns%n", elapsedTime);
  }

  static int solve(List<Integer> nums) {
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