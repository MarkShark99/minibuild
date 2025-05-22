package dev.markdw.minibuild.graph;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import dev.markdw.minibuild.proto.Minibuild.BuildFile;

public class DependencyGraph {
  private static final Pattern labelPattern = Pattern.compile("^\\/\\/([^\\\":]+):([^:]+)$");

  private String cwd;
  private String root;
  private HashMap<String, BuildFile> buildMap;

  public DependencyGraph(String cwd, String root) {
    this.cwd = cwd;
    this.root = root;
  }

  private BuildFile getBuildFile(String label) {
    Matcher labelMatcher = labelPattern.matcher(label);
    if (!labelMatcher.matches()) {
      throw new RuntimeException("Label did not match pattern");
    }

    if (labelMatcher.groupCount() != 2) {
      throw new RuntimeException("Error");
    }

    String path = labelMatcher.group(0);
    if (buildMap.containsKey(path)) {
      return buildMap.get(path);
    }

    
  }

  private class Node {

  }
}
