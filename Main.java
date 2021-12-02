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

import day2.Solution;

class Main {

  private static final Solution SOLUTION = new Solution();

  public static void main(String[] args) {
    /*
    Place your question data into the data.txt file.
    You may need to parse the data!
    */
    Path filePath = Paths.get(SOLUTION.PATH + "/data.txt");
    Charset charset = StandardCharsets.UTF_8;
    List<String> dataLines;
    try {
      dataLines = Files.readAllLines(filePath, charset);
      SOLUTION.second(dataLines);
    } catch (IOException ex) {
            System.out.format("I/O error: %s%n", ex);
    }
  }
}