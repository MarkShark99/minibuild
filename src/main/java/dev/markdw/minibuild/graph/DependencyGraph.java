package dev.markdw.minibuild.graph;

import dev.markdw.minibuild.Util;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import dev.markdw.minibuild.proto.Minibuild.BuildFile;

public class DependencyGraph {
  private String cwd;
  private String root;
  private HashMap<String, BuildFile> labelMap;

  private BuildFile getBuildFile(String label) {
    Matcher labelMatcher = Util.labelPattern.matcher(label);
    if (!labelMatcher.matches()) {
      throw new RuntimeException("Label did not match pattern");
    }

    if (labelMatcher.groupCount() != 2) {
      throw new RuntimeException("Error");
    }

    String path = labelMatcher.group(0);
    if (labelMap.containsKey(path)) {
      return labelMap.get(path);
    }

    return BuildFile.getDefaultInstance();
  }

  private class Node {

  }
}
